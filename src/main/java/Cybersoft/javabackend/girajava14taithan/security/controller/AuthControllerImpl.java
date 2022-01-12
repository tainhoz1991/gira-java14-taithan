package Cybersoft.javabackend.girajava14taithan.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import Cybersoft.javabackend.girajava14taithan.commo.ResponeHandler;
import Cybersoft.javabackend.girajava14taithan.security.jwt.JwtUtils;

@RestController
public class AuthControllerImpl implements AuthController{

	@Autowired
	private JwtUtils jwtUtils;
	
	@Override
	public ResponseEntity<Object> createTemporaryToken(String username) {
		String token = jwtUtils.generateFakeJwtToken(username);
		
		return ResponeHandler.getRespone(token, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> verifyFakeToken(String token) {
		boolean isValid = jwtUtils.validateJwtToken(token);
		return ResponeHandler.getRespone(isValid, HttpStatus.OK);
	}

}
