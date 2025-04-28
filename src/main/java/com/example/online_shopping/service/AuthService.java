package com.example.online_shopping.service;

import java.util.Map;

import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.example.online_shopping.service.dto.LoginDTO;
import com.example.online_shopping.service.dto.UserResetPasswordDTO;

public interface AuthService extends OAuth2UserService<OAuth2UserRequest, OAuth2User> {

	String loginWithPassword(String username, String password);

	String loginWithOtp(String mobileNumber, String otp);

	String resetPassword(UserResetPasswordDTO userResetPasswordDTO);

	String changePassword(UserResetPasswordDTO passwordResetDTO);

	Map<String, Object> loginWithPassword(LoginDTO loginDTO);


}
