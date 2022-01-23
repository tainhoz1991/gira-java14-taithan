package Cybersoft.javabackend.girajava14taithan.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import Cybersoft.javabackend.girajava14taithan.commo.ResponeHandler;
import Cybersoft.javabackend.girajava14taithan.user.dto.UserDto;
import Cybersoft.javabackend.girajava14taithan.user.service.UserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserControllerImpl implements UserController{

	@Autowired
	private UserService service;
	
	@Override
	public ResponseEntity<Object> getUsers() {
		return null;
	}

	@Override
	public ResponseEntity<Object> createUser(@Valid UserDto dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponeHandler.getErrorRespone(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		log.debug("=====creatUser=====");
		log.debug("=====START=====");
		log.debug("CreateUserDTO: {}", dto);
		
		UserDto createUser = service.create(dto);
		
		log.debug("=====creatUser=====");
		log.debug("=====END=====");
		log.debug("Result ==>>> : {}", createUser);
		
		return ResponeHandler.getRespone(createUser, HttpStatus.OK);
	}

}
