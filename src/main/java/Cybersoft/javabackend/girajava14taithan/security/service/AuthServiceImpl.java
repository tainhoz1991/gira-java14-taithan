package Cybersoft.javabackend.girajava14taithan.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Cybersoft.javabackend.girajava14taithan.commo.exception.IncorrectLoginException;
import Cybersoft.javabackend.girajava14taithan.security.dto.LoginDto;
import Cybersoft.javabackend.girajava14taithan.security.jwt.JwtUtils;
import Cybersoft.javabackend.girajava14taithan.user.model.User;
import Cybersoft.javabackend.girajava14taithan.user.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserDetailsService service;
	
	@Autowired
	private JwtUtils utils;
	
	@Override
	public String login(LoginDto dto) {
		Optional<User> userOpt = repository.findByUsername(dto.getUsername());
		
		if (!userOpt.isPresent()) {
			throw new IncorrectLoginException("Incorrect username!!");
		}
		
		String encoderPassword = userOpt.get().getPassword();
		if (!encoder.matches(dto.getPassword(), encoderPassword)) {
			throw new IncorrectLoginException("Incorrect password!!");
		}
		
		UserDetails user = service.loadUserByUsername(dto.getUsername());
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		String token = utils.generateJwtToken(auth);
		
		return token;
	}

}
