package Cybersoft.javabackend.girajava14taithan.commo.exception;

public class IncorrectLoginException extends GiraRuntimeException{
	private static final long serialVersionUID = 1L;

	public IncorrectLoginException() {
		super();
	}
	
	public IncorrectLoginException(String message) {
		super(message);
	}
}
