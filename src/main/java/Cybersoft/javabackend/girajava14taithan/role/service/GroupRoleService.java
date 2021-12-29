package Cybersoft.javabackend.girajava14taithan.role.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import Cybersoft.javabackend.girajava14taithan.role.dto.GroupRoleDto;
import Cybersoft.javabackend.girajava14taithan.role.model.GroupRole;

public interface GroupRoleService {

	List<GroupRoleDto> fillAllGroupRoleDto();

	GroupRoleDto create(@Valid GroupRoleDto groupRoleDto);

	Optional<GroupRole> findByName(String groupRoleName);

	Optional<GroupRole> findByCode(String groupRoleCode);

}
