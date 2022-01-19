package Cybersoft.javabackend.girajava14taithan.user.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import Cybersoft.javabackend.girajava14taithan.user.validation.validator.UniqueUserEmailValidator;

@Constraint(validatedBy = UniqueUserEmailValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUserEmail {

	String message() default "Cannot create user";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
