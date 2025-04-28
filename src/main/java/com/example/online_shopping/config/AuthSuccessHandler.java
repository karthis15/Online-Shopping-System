package com.example.online_shopping.config;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.online_shopping.enums.UserRole;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@Component
//public class AuthSuccessHandler implements AuthenticationSuccessHandler {
//
//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//			Authentication authentication) throws IOException, ServletException {
//		
//		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//		
//		Set<String> roles = AuthorityUtils.authorityListToSet(authorities);
//		
//		if(roles.contains(UserRole.ADMIN.getName()))
//		{
//			response.sendRedirect("/admin/");
//		}else {
//			response.sendRedirect("/");
//		}
//		
//	}
//
//}
