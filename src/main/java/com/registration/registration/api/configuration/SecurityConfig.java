package com.registration.registration.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfig  {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
		http.authorizeHttpRequests((authorizeHttpRequests) ->
				authorizeHttpRequests
					.requestMatchers("/authnz/super/**").hasRole("SUPER")
					.requestMatchers("/authnz/**").authenticated()
					.anyRequest().permitAll() )
//			.userDetailsService(userDetailsService)
			.csrf(c -> c.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) )
			.exceptionHandling((e) ->e.accessDeniedPage("/failure") )
			.logout(l -> l.logoutSuccessUrl("/")
					.permitAll()
					.deleteCookies("JSESSIONID")
					.invalidateHttpSession(true) )
			.oauth2Login()
			.userInfoEndpoint()
			;
		 DefaultSecurityFilterChain build = http.build();
		 return build;
	}
	 @Bean
	 public InMemoryUserDetailsManager userDetailsService() {
		 UserDetails user = User.withDefaultPasswordEncoder()
				 .roles("SUPER")
				 .build();
		 return new InMemoryUserDetailsManager(user);
	 }

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	    return authenticationConfiguration.getAuthenticationManager();
	}
//	@Bean
// 	public UserDetailsService userDetailsService() {
//		UserDetailsService svc = new MyUserDetailsService();
//		return svc;
// 	}
//	private static class MyUserDetailsService implements UserDetailsService{
//
//		@Override
//		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//			System.out.println("load by username");
//			List<GrantedAuthority> authorities = new ArrayList<>();
//			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//			authorities.add(new SimpleGrantedAuthority("ROLE_SUPER"));
//			UserDetails userDetails = User.builder()
//			                        .authorities(authorities)
//			                        .build();
//			UserDetails userDetails = User.builder().roles("ADMIN","SUPER").build();
//			return userDetails;
//		}
//		
//	}
}
