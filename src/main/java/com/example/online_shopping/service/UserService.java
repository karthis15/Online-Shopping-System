package com.example.online_shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

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

	String imageUploadFileUser(MultipartFile file, String id);

	User saveAdmin(User user);

	User updateUserProfile(User user, MultipartFile img);

	User updateUser(User loggedInUserDetails);

	User getUserByEmail(String email);

	Boolean existsEmail(String email);

	void updateUserResetToken(String email, String resetToken);

	User getUserByToken(String token);

	List<User> getUsers(String string);

	Boolean updateAccountStatus(String id, Boolean status);

	void resetAttempt(String userId);

	User saveUser(User user);



}
