package Cybersoft.javabackend.girajava14taithan.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import Cybersoft.javabackend.girajava14taithan.commo.ResponeHandler;
import Cybersoft.javabackend.girajava14taithan.security.dto.LoginDto;
import Cybersoft.javabackend.girajava14taithan.security.service.AuthService;

@RestController
public class AuthControllerImpl implements AuthController{

	@Autowired 
	private AuthService service;
	
	@Override
	public ResponseEntity<Object> login(@Valid LoginDto dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponeHandler.getErrorRespone(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		String token = service.login(dto);
		
		return ResponeHandler.getRespone(token, HttpStatus.OK);
	}


}
