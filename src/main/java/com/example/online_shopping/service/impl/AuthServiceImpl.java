package com.example.online_shopping.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.online_shopping.domain.User;
import com.example.online_shopping.enums.UserRole;
import com.example.online_shopping.repository.UserRepository;
import com.example.online_shopping.service.AuthService;
import com.example.online_shopping.service.OtpService;
import com.example.online_shopping.service.dto.LoginDTO;
import com.example.online_shopping.service.dto.UserDTO;
import com.example.online_shopping.service.dto.UserResetPasswordDTO;
import com.example.online_shopping.service.mapper.UserMapper;
import com.example.online_shopping.util.JwtTokenUtil;

@Service
public class AuthServiceImpl extends DefaultOAuth2UserService implements AuthService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private OtpService otpService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public Map<String, Object> loginWithPassword(LoginDTO loginDTO) {
		User user = userRepository.findByLogin(loginDTO.getUserName());

		if (user == null) {
			user = userRepository.findByEmailAndIsRecordDeletedFalse(loginDTO.getUserName());
			if (user == null) {
				throw new UsernameNotFoundException("User not found with login: " + loginDTO.getUserName());
			}
		}

		if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
			throw new RuntimeException("Invalid credentials");
		}

		String token = jwtTokenUtil.generateToken(user.getUserName());
		UserDTO userDTO = userMapper.toDto(user);
		userDTO.setPassword(null);
		Map<String, Object> response = new HashMap<>();
		response.put("token", token);
		response.put("user", userDTO); // You may exclude sensitive fields

		return response;

	}

	public String loginWithOtp(String mobileNumber, String otp) {
		User user = userRepository.findByMobileNumber(mobileNumber);
		if (!otpService.validateOtp(mobileNumber, otp)) {
			throw new RuntimeException("Invalid OTP");
		}
		return jwtTokenUtil.generateToken(user.getUserName());
	}

	@Override
	public String resetPassword(UserResetPasswordDTO userResetPasswordDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changePassword(UserResetPasswordDTO passwordResetDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String loginWithPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		// OAuth2User oAuth2User = new DefaultOAuth2UserService().loadUser(userRequest);
		OAuth2User oAuth2User = super.loadUser(userRequest);

		String email = oAuth2User.getAttribute("email");
		User user = userRepository.findByEmailAndIsRecordDeletedFalse(email);
		if (user == null) {
			// New Gmail user - register them
			User newUser = new User();
			newUser.setEmail(email);
			newUser.setUserName(oAuth2User.getAttribute("name"));
			newUser.setRole(UserRole.USER.getName());
			 userRepository.save(newUser);
		}

		 return new DefaultOAuth2User(
	                Collections.singleton(() -> "ROLE_" + user.getRole().toUpperCase()),
	                oAuth2User.getAttributes(),
	                "email"
	        );
	    }
	
}