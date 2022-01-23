package Cybersoft.javabackend.girajava14taithan.commo.exception;

import javax.persistence.EntityNotFoundException;

public class GiraEntityNotFoundException extends EntityNotFoundException{
	public GiraEntityNotFoundException() {
		super();
	}
	
	public GiraEntityNotFoundException(String massage) {
		super(massage);
	}
}
