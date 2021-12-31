package Cybersoft.javabackend.girajava14taithan.role.exception;

public class InvalidRoleException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InvalidRoleException() {
		super();
	}
	
	public InvalidRoleException(String message) {
		super(message);
	}
	
	public InvalidRoleException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
