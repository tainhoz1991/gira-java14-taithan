package Cybersoft.javabackend.girajava14taithan.role.service;

import java.util.List;


import org.springframework.stereotype.Service;

import Cybersoft.javabackend.girajava14taithan.role.dto.RoleDto;
import Cybersoft.javabackend.girajava14taithan.role.model.Role;
import Cybersoft.javabackend.girajava14taithan.role.repository.RoleRepository;
import Cybersoft.javabackend.girajava14taithan.role.util.RoleConverter;

@Service
public class RoleServiceImpl implements RoleService{
	private RoleRepository repository;
	public RoleServiceImpl(RoleRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<RoleDto> findAllDto() {
		List<Role> roles = repository.findAll();
		
		return RoleConverter.toRoleDtos(roles);
	}

	@Override
	public RoleDto create(RoleDto dto) {
		Role role = RoleConverter.toRole(dto);
		System.out.println(role.getName());
		Role createRole = repository.save(role);
		
		return RoleConverter.toRoleDto(createRole);
	}

}
