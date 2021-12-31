package Cybersoft.javabackend.girajava14taithan.role.dto;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UpdateGroupRoleDto {
	
	@NotBlank(message = "{grouprole.name.not-blank}")
	private String name;
	
	@NotBlank(message = "{grouprole.code.not-blank}")
	private String code;
	
	@NotBlank(message = "{grouprole.description.not-blank}")
	private String description;

}
