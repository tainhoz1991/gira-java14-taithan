package Cybersoft.javabackend.girajava14taithan.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import Cybersoft.javabackend.girajava14taithan.security.jwt.JwtAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtAuthenticationFilter filter;
	
	// ma hoa password bang interface passwordencoder
	// theo bcrypyt algrorithm
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// co the customize lai authenticationmanager(interface)
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(getPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// cau hinh CORS
		http.cors();
		
		// cau hinh session
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// disable csrf
		http.csrf().disable();
		
		// add jwt filter
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		
		// cau hinh xac thuc cho cac api
		http.antMatcher("/**").authorizeRequests()
			.antMatchers("/swagger-ui.html").permitAll()
			.antMatchers("/swagger-ui/**").permitAll()
			.antMatchers("/openapi/**").permitAll()
			.antMatchers("/api/login").permitAll()
			.antMatchers("/api/users").permitAll()
			.antMatchers("/api/**").permitAll()
			.anyRequest().authenticated();
	}
}
