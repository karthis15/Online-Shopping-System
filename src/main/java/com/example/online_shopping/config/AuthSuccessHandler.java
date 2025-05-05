package com.example.online_shopping.config;

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
