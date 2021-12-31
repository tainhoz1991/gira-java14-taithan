package Cybersoft.javabackend.girajava14taithan.role.service;

import java.util.List;
import java.util.Optional;


import Cybersoft.javabackend.girajava14taithan.role.dto.GroupRoleDto;
import Cybersoft.javabackend.girajava14taithan.role.dto.UpdateGroupRoleDto;
import Cybersoft.javabackend.girajava14taithan.role.model.GroupRole;

public interface GroupRoleService {

	List<GroupRoleDto> fillAllGroupRoleDto();

	GroupRoleDto create(GroupRoleDto groupRoleDto);

	Optional<GroupRole> findByName(String groupRoleName);

	Optional<GroupRole> findByCode(String groupRoleCode);

	GroupRoleDto update(long id, UpdateGroupRoleDto dto);

	void delete(long id);

}
