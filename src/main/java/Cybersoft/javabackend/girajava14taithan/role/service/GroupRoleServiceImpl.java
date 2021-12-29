package Cybersoft.javabackend.girajava14taithan.role.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import Cybersoft.javabackend.girajava14taithan.role.dto.GroupRoleDto;
import Cybersoft.javabackend.girajava14taithan.role.model.GroupRole;
import Cybersoft.javabackend.girajava14taithan.role.repository.GroupRoleRepository;
import Cybersoft.javabackend.girajava14taithan.role.util.GroupRoleConverter;

@Service
public class GroupRoleServiceImpl implements GroupRoleService{
	private GroupRoleRepository repository;
	
	public GroupRoleServiceImpl(GroupRoleRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<GroupRoleDto> fillAllGroupRoleDto() {
		List<GroupRole> groupRole = repository.findAll();
		return GroupRoleConverter.toGroupRoleDtos(groupRole);
	}

	@Override
	public GroupRoleDto create(@Valid GroupRoleDto groupRoleDto) {
		GroupRole groupRole = GroupRoleConverter.toGroupRole(groupRoleDto);
		GroupRole creatGroupRole = repository.save(groupRole);
		
		return GroupRoleConverter.toGroupRoleDto(creatGroupRole);
	}

	@Override
	public Optional<GroupRole> findByName(String groupRoleName) {
		return repository.findByName(groupRoleName);
	}

	@Override
	public Optional<GroupRole> findByCode(String groupRoleCode) {
		return repository.findByCode(groupRoleCode);
	}
	
	
}
