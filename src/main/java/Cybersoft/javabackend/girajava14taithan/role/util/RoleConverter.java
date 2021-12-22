package Cybersoft.javabackend.girajava14taithan.role.util;

import java.util.ArrayList;
import java.util.List;

import Cybersoft.javabackend.girajava14taithan.role.dto.RoleDto;
import Cybersoft.javabackend.girajava14taithan.role.model.Role;

public class RoleConverter {

	public static RoleDto toRoleDto(Role role) {
		return RoleDto.builder()
			.id(role.getId())
			.code(role.getCode())
			.name(role.getName())
			.description(role.getDescription())
			.build();
	}
	
	
	public static List<RoleDto> toRoleDtos(List<Role> roles){
		List<RoleDto> roleDtos = new ArrayList<RoleDto>();
		for(Role role: roles) {
			roleDtos.add(RoleConverter.toRoleDto(role));
		}
		return roleDtos;
		
	}


	public static Role toRole(RoleDto dto) {
		return Role.builder()
				.name(dto.getName())
				.code(dto.getCode())
				.description(dto.getDescription())
				.build();
	}
}
