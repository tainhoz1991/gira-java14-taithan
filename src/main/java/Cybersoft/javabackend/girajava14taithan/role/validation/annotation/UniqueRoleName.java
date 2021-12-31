package Cybersoft.javabackend.girajava14taithan.role.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import Cybersoft.javabackend.girajava14taithan.role.validation.validator.UniqueRoleNameValidator;

@Constraint(validatedBy = UniqueRoleNameValidator.class) // nhan biet duoc class UniqueRoleNameValidator
@Target(ElementType.FIELD) // dung cai annotation nay cho nao, co the quy dinh nhieu target
@Retention(RetentionPolicy.RUNTIME) // quy dinh no chay trong truong hop nao
public @interface UniqueRoleName {
	String message() default "Role name is used";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
