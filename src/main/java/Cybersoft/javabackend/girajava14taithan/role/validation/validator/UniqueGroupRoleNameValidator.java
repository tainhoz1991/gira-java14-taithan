package Cybersoft.javabackend.girajava14taithan.role.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import Cybersoft.javabackend.girajava14taithan.role.model.GroupRole;
import Cybersoft.javabackend.girajava14taithan.role.service.GroupRoleService;
import Cybersoft.javabackend.girajava14taithan.role.validation.annotation.UniqueGroupRoleName;

public class UniqueGroupRoleNameValidator implements ConstraintValidator<UniqueGroupRoleName, String>{
	@Autowired
	private GroupRoleService service;
	private String message;
	
	@Override
	public void initialize(UniqueGroupRoleName uniqueGroupRoleName) {
		ConstraintValidator.super.initialize(uniqueGroupRoleName);
		this.message = uniqueGroupRoleName.message();
	}

	@Override
	public boolean isValid(String groupRoleName, ConstraintValidatorContext context) {
		Optional<GroupRole> groupRoleOpt = service.findByName(groupRoleName);
		if (!groupRoleOpt.isPresent()) {
			return true;
		}
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation().disableDefaultConstraintViolation();
		return false;
	}

}
