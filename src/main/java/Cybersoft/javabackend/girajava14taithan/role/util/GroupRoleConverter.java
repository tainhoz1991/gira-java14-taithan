package Cybersoft.javabackend.girajava14taithan.role.util;

import java.util.ArrayList;
import java.util.List;

import Cybersoft.javabackend.girajava14taithan.role.dto.GroupRoleDto;
import Cybersoft.javabackend.girajava14taithan.role.model.GroupRole;

public class GroupRoleConverter {

	public static GroupRoleDto toGroupRoleDto(GroupRole groupRole) {
		return GroupRoleDto.builder()
				.id(groupRole.getId())
				.name(groupRole.getName())
				.code(groupRole.getCode())
				.description(groupRole.getDescription())
				.build();
	}
	
	public static List<GroupRoleDto> toGroupRoleDtos(List<GroupRole> groupRoles){
		List<GroupRoleDto> groupRoleDtos = new ArrayList<GroupRoleDto>();
		for(GroupRole groupRole: groupRoles) {
			groupRoleDtos.add(GroupRoleConverter.toGroupRoleDto(groupRole));
		}
		return groupRoleDtos;
		
	}
	
	public static GroupRole toGroupRole(GroupRoleDto groupRoleDto) {
		return GroupRole.builder()
				.name(groupRoleDto.getName())
				.code(groupRoleDto.getCode())
				.description(groupRoleDto.getDescription())
				.build();
	}
}
