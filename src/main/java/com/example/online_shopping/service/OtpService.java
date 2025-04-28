package com.example.online_shopping.service;

public interface OtpService {

	boolean validateOtp(String mobileNumber, String otp);

	String generateOtp(String mobileNumber);

}
