package com.example.online_shopping.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.online_shopping.service.dto.AppUserDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

//	@Value("${security.jwt.token.secret-key:secret}")
//	private String secretKey = "secret";
	private final String SECRET_KEY = "mySecretKeykarthiswaran15051999IsMySecret123456";

	public String generateToken(AppUserDTO user) {
		Map<String, Object> claims = new HashMap<>();

		return Jwts.builder().claims().add(claims).subject(user.getUserName())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 60 * 60 * 30)).and().signWith(getKey()).compact();

	}

	private SecretKey getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public String getUsername(String token) {
		logger.info("User name ::" + token);
		return extractClaim(token, Claims::getSubject);
	}

	public boolean validateToken(String authToken, UserDetails userDetails) {
		return validateToken(authToken);
	}

	public boolean validateToken(String token) {
		try {
			Date expiration = extractExpiration(token);
			Date now = new Date();
			logger.info("Token expires at: {}, Current time: {}", expiration, now);
			return expiration.after(now);
		} catch (JwtException | IllegalArgumentException e) {
			logger.warn("Invalid JWT token: {}", e.getMessage());
			// throw new InvalidJwtAuthenticationException("Expired or invalid JWT token");
		}
		return false;
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token).getPayload();
	}

	public String checkUserName(String token) {
		return extractClaim(token, Claims::getSubject);
	}

}
