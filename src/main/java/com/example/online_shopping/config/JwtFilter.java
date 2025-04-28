package com.example.online_shopping.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.online_shopping.util.Constant;
import com.example.online_shopping.util.JwtTokenUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@Autowired
	@Lazy // Lazy initialization for UserDetailsService to break circular reference
	private UserDetailsService userDetailsService;

//	@Override
//	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
//			throws ServletException, IOException {
//		String AuthHeader=request.getHeader(Constant.HEADER_STRING);
//		String token=null;
//		String username=null;
//		
//		if (AuthHeader != null && AuthHeader.startsWith(Constant.TOKEN_PREFIX)) {
//			token = AuthHeader.replace(Constant.TOKEN_PREFIX, "");
//			username = jwtTokenUtil.checkUserName(token);
//		}
//		if(username != null && SecurityContextHolder.getContext().getAuthentication()==null) {
//			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//			if(jwtTokenUtil.validateToken(token,userDetails)) {
//				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,
//						token, null);
//				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				SecurityContextHolder.getContext().setAuthentication(authentication);
//				
//			}
//		}
//		filterChain.doFilter(request, response);
//		
//		
//	}

	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
			@NonNull FilterChain filterChain) throws ServletException, IOException {

		String authHeader = request.getHeader("Authorization"); // or your Constant.HEADER_STRING
		String token = null;
		String username = null;

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7);
			username = jwtTokenUtil.extractUsername(token); // your method to extract username
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);

			if (jwtTokenUtil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());

				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}

		// Important: continue the filter chain (whether token was there or not)
		filterChain.doFilter(request, response);
	}

}
