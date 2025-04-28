package com.example.online_shopping.rest;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.online_shopping.service.AuthService;
import com.example.online_shopping.service.OtpService;
import com.example.online_shopping.service.dto.LoginDTO;
import com.example.online_shopping.service.dto.UserResetPasswordDTO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
public class AuthResource {
    @Autowired
    private AuthService authService;
    @Autowired
    private OtpService otpService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO loginDTO) {
 //       Map<String, Object> response = authService.loginWithPassword(loginDTO);
        try {
//			UsernamePasswordAuthenticationToken authToken =
//				new UsernamePasswordAuthenticationToken(loginDTO.getUserName(), loginDTO.getPassword());
			  Map<String, Object> response = authService.loginWithPassword(loginDTO);

//			  Authentication token = (Authentication) response.values().stream().findFirst().orElse(null);
//			Authentication authentication = authenticationManager.authenticate(token);
//			SecurityContextHolder.getContext().setAuthentication(authentication);

//			Map<String, Object> response = new HashMap<>();
			response.put("message", "Login successful");
			response.put("username", loginDTO.getUserName());

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			Map<String, Object> error = new HashMap<>();
			error.put("message", "Invalid username/email or password");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
		}
	}
    
    @GetMapping("/oauth2/success")
    public String oauth2Success(Authentication authentication, HttpSession session) {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        session.setAttribute("user", oAuth2User.getAttributes());
        return "redirect:/home";  // or redirect based on role
    }


    @PostMapping("/otp")
    public ResponseEntity<String> generateOtp(@RequestParam String mobileNumber) {
        otpService.generateOtp(mobileNumber);
        return ResponseEntity.ok("OTP Sent");
    }

    @PostMapping("/login/otp")
    public ResponseEntity<String> loginWithOtp(@RequestParam String mobileNumber, @RequestParam String otp) {
        String token = authService.loginWithOtp(mobileNumber, otp);
        return ResponseEntity.ok(token);
    }
    
	@PostMapping("/resetPassword")
	public String forgetPassword(@RequestBody UserResetPasswordDTO userResetPasswordDTO) {
		return authService.resetPassword(userResetPasswordDTO);
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestBody UserResetPasswordDTO passwordResetDTO) throws SQLException {
		return authService.changePassword(passwordResetDTO);
	}
}
