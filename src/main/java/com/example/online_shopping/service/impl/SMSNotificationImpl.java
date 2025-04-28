//package com.example.online_shopping.service.impl;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//
//@Service
//public class SMSNotificationImpl {
////
////    @Value("${twilio.account-sid}")
////    private String accountSid;
////
////    @Value("${twilio.auth-token}")
////    private String authToken;
//
//	@Value("${twilio.from-number}")
//	private String fromNumber;
//
//	public void sendSms(String to, String message) {
//		try {
//			Message.creator(new PhoneNumber(to), new PhoneNumber(fromNumber), message).create();
//			System.out.println("SMS sent successfully to " + to);
//		} catch (Exception e) {
//			System.err.println("Error sending SMS: " + e.getMessage());
//		}
//	}
//}