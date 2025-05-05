package com.example.online_shopping.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.online_shopping.service.impl.AuthServiceImpl;
import com.example.online_shopping.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	@Lazy // Lazy initialization to avoid circular dependency
	private AuthFailureHandler authenticationFailureHandler;

	@Autowired
	@Lazy // Lazy initialization for JwtFilter to prevent circular reference
	private JwtAuthenticationFilter jwtFilter;

	private final Logger log = LoggerFactory.getLogger(SecurityConfig.class);
	private static final String[] SWAGGER_UNSECURE_PATTERNS = { "/**/swagger-ui/**", "/api/swagger.json",
			"/**/v2/api-docs", "/**/v3/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security",
			"/webjars/**", "/swagger-resources/configuration/ui", "/swagger-resources/configuration/security",
			"/actuator/prometheus" };

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll() // Allow all requests
//		)
//				// .antMatchers("/**/swagger-ui/**")
//				.csrf(csrf -> csrf.disable()) // Disable CSRF for testing purposes
//				.formLogin(form -> form.disable()) // Disable default login page
//				.httpBasic(basic -> basic.disable()); // Disable basic authentication
//
//		return http.build();

//		return http.csrf(customizer -> customizer.disable()).authorizeHttpRequests(request -> request
//				.requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/forgot-password", "/img/**", "/css/**","/register", "/signin", "/","/forgot-password",
//						"/saveUser","/js/**", "/index.html", "/api/auth/**", "/api/register/tbl-users")
//				.permitAll()
//				.requestMatchers("/admin/**").hasRole("ADMIN").requestMatchers("/user/**").hasRole("USER")
//
//				.anyRequest().authenticated())
//				.formLogin(form -> form.loginPage("/signin").loginProcessingUrl("/login").defaultSuccessUrl("/")
//						.successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler))
//				.oauth2Login(oauth2 -> oauth2.loginPage("/signin").defaultSuccessUrl("/", true))
//				.logout(logout -> logout.permitAll())
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class).build();
//
//	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/webjars/**","/error", "/swagger-ui/**", "/v3/api-docs/**", "/img/**", "/css/**", "/js/**",
								"/register", "/signin", "/", "/forgot-password", "/saveUser", "/index.html",
								"/api/auth/**", "/api/register/tbl-users")
						.permitAll().requestMatchers("/admin/**").hasRole("ADMIN").requestMatchers("/user/**")
						.hasRole("USER").anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/signin").loginProcessingUrl("/login").defaultSuccessUrl("/")
						.successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler)
						.permitAll())
				.oauth2Login(oauth2 -> oauth2.loginPage("/signin").defaultSuccessUrl("/", true))
				.logout(logout -> logout.permitAll())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // ✅
																												// allows
																												// session-based
																												// auth
				);

		return http.build();
	}

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
//				auth -> auth.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
//						.anyRequest().permitAll() // All endpoints are public
//		);
//
//		return http.build();
//	}

//	@Bean
//	public AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider dProvider = new DaoAuthenticationProvider();
//		dProvider.setPasswordEncoder(passwordEncoder());
//		dProvider.setUserDetailsService(userDetailsService);
//		return dProvider;
//
//	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public OAuth2UserService<OAuth2UserRequest, OAuth2User> customOAuth2UserService() {
		return new AuthServiceImpl(); // Your custom implementation
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
