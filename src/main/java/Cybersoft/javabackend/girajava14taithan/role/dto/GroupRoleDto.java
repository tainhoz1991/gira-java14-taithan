package Cybersoft.javabackend.girajava14taithan.role.dto;

import javax.validation.constraints.NotBlank;

import Cybersoft.javabackend.girajava14taithan.role.validation.annotation.UniqueGroupRoleCode;
import Cybersoft.javabackend.girajava14taithan.role.validation.annotation.UniqueGroupRoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupRoleDto {
	
	private long id;
	
	@UniqueGroupRoleName(message = "GroupRole name is used!")
	@NotBlank(message = "{grouprole.name.not-blank}")
	private String name;
	
	@UniqueGroupRoleCode(message = "GroupRole code is used")
	@NotBlank(message = "{grouprole.name.not-blank}")
	private String code;
	
	@NotBlank(message = "{grouprole.name.not-blank}")
	private String description;
}
