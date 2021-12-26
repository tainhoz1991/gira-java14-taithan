package Cybersoft.javabackend.girajava14taithan.role.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import Cybersoft.javabackend.girajava14taithan.role.model.Role;
import Cybersoft.javabackend.girajava14taithan.role.service.RoleService;
import Cybersoft.javabackend.girajava14taithan.role.validation.annotation.UniqueRoleName;

public class UniqueRoleNameValidator implements ConstraintValidator<UniqueRoleName, String> {
	@Autowired
	private RoleService service;
	private String message;
	
	@Override
	public void initialize(UniqueRoleName uniqueRoleNameValidator) { //set cac gia tri ban dau
		ConstraintValidator.super.initialize(uniqueRoleNameValidator);
		this.message = uniqueRoleNameValidator.message();
	}
	
	@Override
	public boolean isValid(String roleName, ConstraintValidatorContext context) {
		Optional<Role> roleOpt = service.findByName(roleName); // xai optinal tranh viec bi null
		if(!roleOpt.isPresent())
			return true;
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
