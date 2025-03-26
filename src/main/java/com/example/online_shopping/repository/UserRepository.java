package com.example.online_shopping.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.online_shopping.domain.User;

@Repository
public interface UserRepository
		extends JpaRepository<User, String> {

	User findByEmail(String username);

}
