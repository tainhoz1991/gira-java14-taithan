package Cybersoft.javabackend.girajava14taithan.commo.util;

import java.util.LinkedList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ErrorUtil {

	public static Object solveError(BindingResult bindingResult) {
		List<String> errorMessage = new LinkedList<>();
		List<ObjectError> errors = bindingResult.getAllErrors();

		for (ObjectError error: errors) {
			//System.out.println(error.getDefaultMessage());
			errorMessage.add(error.getDefaultMessage());
		}
		return errorMessage;
	}

}