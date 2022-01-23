package Cybersoft.javabackend.girajava14taithan.role.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import Cybersoft.javabackend.girajava14taithan.role.model.GroupRole;

@Mapper
public interface GroupMapper {
	GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);
	
	GroupRoleDto fromEntityGroupRoleDto(GroupRole group);
	
	GroupRole fromGroupRoleDtoToEntity(GroupRoleDto dto);
}
