package Cybersoft.javabackend.girajava14taithan.role.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupRoleDto {
	private long id;
	@NotBlank(message = "GroupRole name can not be blank!")
	private String name;
	@NotBlank(message = "GroupRole code can not be blank!")
	private String code;
	@NotBlank(message = "GroupRole description can not be blank!")
	private String description;
}
