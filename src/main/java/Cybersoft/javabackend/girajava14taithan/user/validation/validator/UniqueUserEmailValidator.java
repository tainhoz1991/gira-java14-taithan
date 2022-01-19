package Cybersoft.javabackend.girajava14taithan.user.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import Cybersoft.javabackend.girajava14taithan.user.model.User;
import Cybersoft.javabackend.girajava14taithan.user.service.UserService;
import Cybersoft.javabackend.girajava14taithan.user.validation.annotation.UniqueUserEmail;

public class UniqueUserEmailValidator implements ConstraintValidator<UniqueUserEmail, String>{

	@Autowired
	private UserService service;
	private String message;
	
	@Override
	public void initialize(UniqueUserEmail uniqueUserEmail) {
		ConstraintValidator.super.initialize(uniqueUserEmail);
		this.message = uniqueUserEmail.message();
	}
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		Optional<User> userOpt = service.findByEmail(email);
		if (!userOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation().disableDefaultConstraintViolation();
		return false;
	}

}
