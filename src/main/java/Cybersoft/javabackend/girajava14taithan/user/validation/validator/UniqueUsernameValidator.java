package Cybersoft.javabackend.girajava14taithan.user.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import Cybersoft.javabackend.girajava14taithan.user.model.User;
import Cybersoft.javabackend.girajava14taithan.user.service.UserService;
import Cybersoft.javabackend.girajava14taithan.user.validation.annotation.UniqueUsername;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{
	
	@Autowired
	private UserService service;
	private String message;
	
	@Override
	public void initialize(UniqueUsername uniqueUsername) {
		ConstraintValidator.super.initialize(uniqueUsername);
		this.message = uniqueUsername.message();
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		Optional<User> userOpt = service.findByUsername(username);
		if (!userOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation().disableDefaultConstraintViolation();
		return false;
	}

}
