package Cybersoft.javabackend.girajava14taithan.commo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import Cybersoft.javabackend.girajava14taithan.commo.exception.GiraRuntimeException;
import Cybersoft.javabackend.girajava14taithan.commo.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice // lo ve viec xu ly toan bo exception
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = {NotFoundException.class}) // cho spring no biet cai nay xu ly cai exception
	//@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Result was not found") di kem cai respone tra ve
	public Object handleNotFoundException(NotFoundException e) {
		log.debug("ERROR CATCHED: {}", e);
		
		return ResponeHandler.getErrorRespone(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value = {GiraRuntimeException.class})
	public Object handleGiraRuntimeException(GiraRuntimeException e) {
		log.debug("GiraRuntimeException: {}", e.getMessage());
		
		return ResponeHandler.getErrorRespone(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(value = {Exception.class})
	public Object handleUnexpectedException (Exception e) {
		log.error("Error has been occured ===>");
		
		return ResponeHandler.getErrorRespone(e.getMessage()
				, HttpStatus.BAD_REQUEST);
	}
	
}
