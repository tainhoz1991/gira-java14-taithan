package Cybersoft.javabackend.girajava14taithan.role.service;

import java.util.List;

import javax.validation.Valid;

import Cybersoft.javabackend.girajava14taithan.role.dto.GroupRoleDto;

public interface GroupRoleService {

	List<GroupRoleDto> fillAllGroupRoleDto();

	GroupRoleDto create(@Valid GroupRoleDto groupRoleDto);

}
