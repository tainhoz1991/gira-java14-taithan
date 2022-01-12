package Cybersoft.javabackend.girajava14taithan.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	@NotBlank
	private String username;
	
	@NotBlank
	private String email;
	
	@NotBlank
	@Size(min = 8)
	private String password;
	
	@NotBlank
	private String fullname;
	
}
