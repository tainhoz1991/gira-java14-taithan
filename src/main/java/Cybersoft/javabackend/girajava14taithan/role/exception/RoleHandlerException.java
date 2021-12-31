package Cybersoft.javabackend.girajava14taithan.role.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import Cybersoft.javabackend.girajava14taithan.commo.ResponeHandler;

@RestControllerAdvice
public class RoleHandlerException {

	@ExceptionHandler(value = InvalidRoleException.class)
	public Object handleInvalidRoleException(InvalidRoleException e) {
		// tra ve cai exception la doi tuong InvalidRoleException 
		// va gui vao trong noi dung Respone Body
		// bang cach ResponeHandler.getErrorRespone(e.getMessage(), HttpStatus.BAD_REQUEST)
		// e.getMessage() la e extends tu thang class Throwable co phuong thuc getMessage
		return ResponeHandler.getErrorRespone(e.getMessage(), HttpStatus.BAD_REQUEST);
		
	}
}
