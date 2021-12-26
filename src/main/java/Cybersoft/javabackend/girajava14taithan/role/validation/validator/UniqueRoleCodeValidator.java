package Cybersoft.javabackend.girajava14taithan.role.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import Cybersoft.javabackend.girajava14taithan.role.model.Role;
import Cybersoft.javabackend.girajava14taithan.role.service.RoleService;
import Cybersoft.javabackend.girajava14taithan.role.validation.annotation.UniqueRoleCode;

public class UniqueRoleCodeValidator implements ConstraintValidator<UniqueRoleCode, String>{
	@Autowired
	private RoleService service;
	private String message;
	
	@Override
	public void initialize(UniqueRoleCode constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
		this.message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(String code, ConstraintValidatorContext context) {
		Optional<Role> roleOpt = service.findByCode(code);
		if (!roleOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation().disableDefaultConstraintViolation();
		return false;
	}

}
