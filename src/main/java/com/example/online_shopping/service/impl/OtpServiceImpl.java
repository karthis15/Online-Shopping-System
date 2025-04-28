package com.example.online_shopping.service.impl;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.example.online_shopping.service.OtpService;

@Service
public class OtpServiceImpl implements OtpService {

	private final Map<String, String> otpData = new ConcurrentHashMap<>();
	private final Random random = new Random();

	public String generateOtp(String mobileNumber) {
		String otp = String.valueOf(100000 + random.nextInt(900000));
		otpData.put(mobileNumber, otp);
		System.out.println("OTP Sent: " + otp);
		return otp;
	}

	public boolean validateOtp(String mobileNumber, String otp) {
		return otp.equals(otpData.get(mobileNumber));
	}
}