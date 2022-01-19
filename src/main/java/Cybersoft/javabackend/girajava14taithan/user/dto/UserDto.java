package Cybersoft.javabackend.girajava14taithan.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import Cybersoft.javabackend.girajava14taithan.user.validation.annotation.UniqueUserEmail;
import Cybersoft.javabackend.girajava14taithan.user.validation.annotation.UniqueUsername;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	
	@NotBlank
	@UniqueUsername(message = "Username is used!")
	private String username;
	
	@NotBlank
	@UniqueUserEmail(message = "User email is used!")
	private String email;
	
	@NotBlank
	@Size(min = 4)
	private String password;
	
	@NotBlank
	private String fullname;
	
}
