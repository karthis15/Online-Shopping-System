package com.example.online_shopping.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.online_shopping.domain.User;
import com.example.online_shopping.repository.UserRepository;
import com.example.online_shopping.service.UserService;
import com.example.online_shopping.service.dto.UserDTO;
import com.example.online_shopping.service.mapper.UserMapper;
import com.example.online_shopping.util.Constant;

@Service
public class UserServiceImpl implements UserService {

	private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserMapper userMapper;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder(12);

	@Override
	public UserDTO save(UserDTO userDTO) {
		
		
		log.debug("Request to save User : {}", userDTO);
		User user = userMapper.toEntity(userDTO);
		user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
		user = userRepository.save(user);
		UserDTO result = userMapper.toDto(user);
		return result;
	}

	@Override
	public List<UserDTO> findAll() {
		log.debug("Request to get all Users");
		return userRepository.findAll().stream().map(userMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public Optional<UserDTO> findOne(String id) {
		log.debug("Request to get TUser : {}", id);
		return userRepository.findById(id).map(userMapper::toDto);
	}

	@Override
	public void delete(String id) {
		log.debug("Request to delete User : {}", id);
		userRepository.deleteById(id);
	}
	
	@Override
	public void increaseFailedAttempt(User user) {
		int attempt = user.getFailedAttempt() + 1;
		user.setFailedAttempt(attempt);
		userRepository.save(user);
	}
	
	@Override
	public void userAccountLock(User user) {
		user.setIsRecordDeleted(true);
		user.setLoginInOutTime(new Date().toInstant());
		userRepository.save(user);
	}
	
	@Override
	public boolean unlockAccountTimeExpired(User user) {
		
		Date date = Date.from(user.getLoginInOutTime());
		long lockTime = date.getTime();
		long unLockTime = lockTime + Constant.UNLOCK_DURATION_TIME;

		long currentTime = System.currentTimeMillis();

		if (unLockTime < currentTime) {
			user.setIsRecordDeleted(false);
			user.setFailedAttempt(0);
			user.setLoginInOutTime(null);
			userRepository.save(user);
			return true;
		}

		return false;
	}

}
