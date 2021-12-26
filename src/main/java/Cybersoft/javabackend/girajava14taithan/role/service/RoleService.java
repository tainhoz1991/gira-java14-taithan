package Cybersoft.javabackend.girajava14taithan.role.service;

import java.util.List;
import java.util.Optional;

import Cybersoft.javabackend.girajava14taithan.role.dto.RoleDto;
import Cybersoft.javabackend.girajava14taithan.role.model.Role;


public interface RoleService {

	List<RoleDto> findAllDto();

	RoleDto create(RoleDto dto);

	Optional<Role> findByName(String roleName);

	Optional<Role> findByCode(String code);


}
