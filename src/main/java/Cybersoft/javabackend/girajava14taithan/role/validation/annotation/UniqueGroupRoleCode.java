package Cybersoft.javabackend.girajava14taithan.role.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import Cybersoft.javabackend.girajava14taithan.role.validation.validator.UniqueGroupRoleCodeValidator;

@Constraint(validatedBy = UniqueGroupRoleCodeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueGroupRoleCode {

	String message() default "GroupRole name is used";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
