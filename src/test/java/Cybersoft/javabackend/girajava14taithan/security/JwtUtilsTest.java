package Cybersoft.javabackend.girajava14taithan.security;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import Cybersoft.javabackend.girajava14taithan.security.dto.CustomUserDetails;
import Cybersoft.javabackend.girajava14taithan.security.jwt.JwtUtils;

@SpringBootTest
public class JwtUtilsTest {
	
	@Autowired
	private JwtUtils utils;
	
	private Authentication validAuth;
	private Authentication invalidAuth;
	
	@PostConstruct
	public void setupTest() {
		List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
		UserDetails user = new CustomUserDetails("testadmin", "admin", authority);
		validAuth = new UsernamePasswordAuthenticationToken(
				user, 
				null,
				null);
		invalidAuth = new UsernamePasswordAuthenticationToken(
				null, 
				null,
				null);
	}
	
	@Test
	public void shouldInjectJwtUtilSuccessfully() {
		assertNotNull(utils);
	}
	
	@Test
	public void shouldGenerateJwtTokenSuccessfully() {
		String token = utils.generateJwtToken(validAuth);
		
		assertNotNull(token);
	}
	
	@Test
	public void shouldThrowExceptionWhileGenerateJwtToken() {
		assertThrows(null, null);
	}
	
	@Test
	public void shouldValidateCorrectToken() {
		String token = utils.generateJwtToken(validAuth);
		
		assertEquals(utils.validateJwtToken(token), true);
	}
	
	@Test
	public void shouldValidateInCorrectToken() {
		String token = "tainguyengoc";
		
		assertEquals(utils.validateJwtToken(token), false);
	}
	
	@Test
	public void shouldNotPassValidateToken() {
		String token = utils.generateJwtToken(invalidAuth);
		
		assertEquals(utils.validateJwtToken(token), false);
	}
	
}
