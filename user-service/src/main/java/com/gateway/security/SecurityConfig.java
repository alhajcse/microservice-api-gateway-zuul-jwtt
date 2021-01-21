//package com.gateway.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////	@Autowired
////	private MyUserDetailsService myUserDetailsService;
//
//	@Autowired
//	private JwtFilter jwtFilter;
//
////	@Override
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		// TODO Auto-generated method stub
////		super.configure(auth);
////		auth.userDetailsService(myUserDetailsService);
////	}
//
//	@Override
//	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		// TODO Auto-generated method stub
//		return super.authenticationManagerBean();
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		http.csrf().disable().authorizeRequests().antMatchers("/autheticate").permitAll().anyRequest().authenticated()
//				.and().exceptionHandling().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//	}
//
//}
//
