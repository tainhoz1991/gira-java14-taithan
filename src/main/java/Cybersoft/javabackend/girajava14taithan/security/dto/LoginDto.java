package Cybersoft.javabackend.girajava14taithan.security.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
	@NotBlank
	@Size(min = 3, max = 36)
	private String username;
	
	@NotBlank
	@Size(min = 4)
	private String password;
}
