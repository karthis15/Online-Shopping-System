package com.example.online_shopping.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.online_shopping.domain.User;
import com.example.online_shopping.enums.UserRole;
import com.example.online_shopping.repository.UserRepository;
import com.example.online_shopping.service.UserService;
import com.example.online_shopping.service.dto.UserDTO;
import com.example.online_shopping.service.mapper.UserMapper;
import com.example.online_shopping.util.Constant;
import com.example.online_shopping.util.JwtTokenUtil;

@Service
public class UserServiceImpl implements UserService {

	private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserMapper userMapper;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private GoogleDriveServiceImpl driveService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public UserDTO save(UserDTO userDTO) {

		log.debug("Request to save User : {}", userDTO);
		User user = userMapper.toEntity(userDTO);
		user.setId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setRole(UserRole.USER.getName());
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
		Integer attempt = user.getFailedAttempt() + 1;
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

	@Override
	public String imageUploadFileUser(MultipartFile file, String id) {

		return null;
	}

	// Create User Image
//	public User createUser(String userId, MultipartFile file) throws IOException {
//		String url = driveService.uploadImageToDrive(file);
//		User user = new User();
//		user.setId(userId);
//		user.setProfileImage(url);
//		return userRepository.save(user);
//	}
	
	public User createUser(String userId, MultipartFile file) throws IOException {
		return null;
		
	}

	// Get User Image
	public Optional<User> getUser(String userId) {
		return userRepository.findById(userId);
	}

	@Override
	public User getUserByEmail(String email) {
		User user = userRepository.findByEmailAndIsRecordDeletedFalse(email);
		return user;
	}

	@Override
	public Boolean updateAccountStatus(String id, Boolean status) {
		Optional<User> findByuser = userRepository.findById(id);

		if (findByuser.isPresent()) {
			User userDtls = findByuser.get();
			userDtls.setIsRecordDeleted(status);
			userRepository.save(userDtls);
			return true;
		}

		return false;
	}


	@Override
	public User saveUser(User user) {
		user.setRole(UserRole.USER.getName());
		user.setIsActive(true);
		user.setFailedAttempt(0);

		String encodePassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		User saveUser = userRepository.save(user);
		return saveUser;
	}


	@Override
	public List<User> getUsers(String role) {
		return userRepository.findByRole(role);
	}


	@Override
	public void resetAttempt(String userId) {

	}

	@Override
	public void updateUserResetToken(String email, String resetToken) {
//		User findByEmail = userRepository.findByEmailAndIsRecordDeletedFalse(email);
//		findByEmail.setResetToken(resetToken);
//		userRepository.save(findByEmail);
	}

	@Override
	public User getUserByToken(String token) {
		if (jwtTokenUtil.validateToken(token)) {
            String username = jwtTokenUtil.getUsername(token);
            return userRepository.findByUserName(username);
        } else {
            throw new RuntimeException("Invalid token");
        }
    }
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUserProfile(User user, MultipartFile img) {

		User dbUser = userRepository.findById(user.getId()).get();

		if (!img.isEmpty()) {
			dbUser.setProfileImage(img.getOriginalFilename());
		}

		if (!ObjectUtils.isEmpty(dbUser)) {

			dbUser.setUserName(user.getUserName());
			dbUser.setMobileNumber(user.getMobileNumber());
			dbUser.setAddress(user.getAddress());
			dbUser.setCity(user.getCity());
			dbUser.setState(user.getState());
			dbUser.setPincode(user.getPincode());
			dbUser = userRepository.save(dbUser);
		}

		try {
			if (!img.isEmpty()) {
				File saveFile = new ClassPathResource("static/img").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "profile_img" + File.separator
						+ img.getOriginalFilename());

//			System.out.println(path);
				Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dbUser;
	}

	@Override
	public User saveAdmin(User user) {
		user.setRole(UserRole.ADMIN.getName());
		user.setIsActive(true);
		user.setFailedAttempt(0);

		String encodePassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		User saveUser = userRepository.save(user);
		return saveUser;
	}

	@Override
	public Boolean existsEmail(String email) {
		return userRepository.existsByEmail(email);
	}

}
