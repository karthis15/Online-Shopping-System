package com.example.online_shopping.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Autowired
	UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll() // Allow all requests
		)
				// .antMatchers("/**/swagger-ui/**")
				.csrf(csrf -> csrf.disable()) // Disable CSRF for testing purposes
				.formLogin(form -> form.disable()) // Disable default login page
				.httpBasic(basic -> basic.disable()); // Disable basic authentication

		return http.build();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider dProvider = new DaoAuthenticationProvider();
		dProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		dProvider.setUserDetailsService(userDetailsService);
		return dProvider;

	}

//    @Bean
//    public UserDetailsService userDetailsService(){
//    	UserDetails user= User
//    			.withDefaultPasswordEncoder()
//    			.username("ki")
//    			.password("ten")
//    			.roles("user")
//    			.build();
//		return new InMemoryUserDetailsManager();
//    	
//    }
}
