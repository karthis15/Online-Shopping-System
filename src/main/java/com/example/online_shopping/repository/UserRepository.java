package com.example.online_shopping.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.online_shopping.domain.User;
import com.example.online_shopping.service.dto.UserDTO;

@Repository
public interface UserRepository
		extends JpaRepository<User, String> {

	User findByEmailAndIsRecordDeletedFalse(String email);

	User findByMobileNumber(String mobileNumber);

	User findByLogin(String login);

	List<User> findByRole(String role);

	Boolean existsByEmail(String email);

	User findByUserName(String username);


}
