package Cybersoft.javabackend.girajava14taithan.role.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import Cybersoft.javabackend.girajava14taithan.role.model.GroupRole;
import Cybersoft.javabackend.girajava14taithan.role.service.GroupRoleService;
import Cybersoft.javabackend.girajava14taithan.role.validation.annotation.UniqueGroupRoleCode;

public class UniqueGroupRoleCodeValidator implements ConstraintValidator<UniqueGroupRoleCode, String>{
	
	@Autowired
	private GroupRoleService service;
	private String message;
	
	@Override
	public void initialize(UniqueGroupRoleCode uniqueGroupRoleCode) {
		ConstraintValidator.super.initialize(uniqueGroupRoleCode);
		this.message = uniqueGroupRoleCode.message();
	}

	@Override
	public boolean isValid(String groupRoleCode, ConstraintValidatorContext context) {
		Optional<GroupRole> groupRoleOpt = service.findByCode(groupRoleCode);
		
		if (!groupRoleOpt.isPresent()) {
			return true;
		}
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation().disableDefaultConstraintViolation();
		
		return false;
	}

}
