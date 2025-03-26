package com.example.online_shopping.service;

import java.util.List;
import java.util.Optional;

import com.example.online_shopping.domain.User;
import com.example.online_shopping.service.dto.UserDTO;

public interface UserService {

	UserDTO save(UserDTO userDTO);

	List<UserDTO> findAll();

	Optional<UserDTO> findOne(String id);

	void delete(String id);

	void increaseFailedAttempt(User user);

	void userAccountLock(User user);

	boolean unlockAccountTimeExpired(User user);


}
