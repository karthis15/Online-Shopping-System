package com.example.online_shopping.security;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, proxyTargetClass = true)
public class SecurityConfig   {
//	private final Logger log = LoggerFactory.getLogger(SecurityConfig.class);
//	private static final String[] SWAGGER_UNSECURE_PATTERNS = { 
//			"/**/swagger-ui/**",
//    		"/api/swagger.json",
//            "/**/v2/api-docs",
//            "/**/v3/api-docs"};
	//extends WebSecurityConfigurerAdapter
//
//	@Autowired
//	UrlSecureConfig urlConfig;
//	
//	@Autowired
//	PropertyConfig propertyConfig;
//
//	@Autowired
//	private JwtAuthenticationEntryPoint unauthorizedHandler;
//
//	@Resource(name = "userService")
//	private UserDetailsService userDetailsService;
//
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//	@Bean
//	public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
//		return new JwtAuthenticationFilter();
//	}
//
//	@Autowired
//	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
//		http.cors().and().csrf().disable().authorizeRequests().antMatchers(urlConfig.getUnsecureArray()).permitAll()
//				.antMatchers(SWAGGER_UNSECURE_PATTERNS)
//				// --TODO remove after checked
//				.permitAll().anyRequest().authenticated().and().exceptionHandling()
//				.authenticationEntryPoint(unauthorizedHandler).and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		
//		http.headers().cacheControl().disable();
//		
//		//runtime config print
//		log.info("%%%%%%**** Runtime config Property Start *******%%%%%%%%%");
//		log.info(propertyConfig.toString());
//		log.info("**** Runtime config Property end *******");
//	}

}