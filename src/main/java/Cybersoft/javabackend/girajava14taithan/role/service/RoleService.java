package Cybersoft.javabackend.girajava14taithan.role.service;

import java.util.List;


import Cybersoft.javabackend.girajava14taithan.role.dto.RoleDto;


public interface RoleService {

	List<RoleDto> findAllDto();

	RoleDto create(RoleDto dto);

}
