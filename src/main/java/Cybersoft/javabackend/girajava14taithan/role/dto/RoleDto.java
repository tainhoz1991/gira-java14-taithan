package Cybersoft.javabackend.girajava14taithan.role.dto;

import javax.validation.constraints.NotBlank;

import Cybersoft.javabackend.girajava14taithan.role.validation.annotation.UniqueRoleCode;
import Cybersoft.javabackend.girajava14taithan.role.validation.annotation.UniqueRoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder //ho tro...???
public class RoleDto {
	
	private long id;
	
	@NotBlank(message = "{role.name.not-blank}")
	@UniqueRoleName(message = "abcxyz")
	private String name;
	
	@NotBlank(message = "{role.code.not-blank}")
	@UniqueRoleCode(message = "Role code is used")
	private String code;
	
	@NotBlank(message = "{role.description.not-blank}")
	private String description;
	
	
}
