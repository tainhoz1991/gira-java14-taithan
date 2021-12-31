package Cybersoft.javabackend.girajava14taithan.role.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import Cybersoft.javabackend.girajava14taithan.role.dto.GroupRoleDto;
import Cybersoft.javabackend.girajava14taithan.role.dto.UpdateGroupRoleDto;
import Cybersoft.javabackend.girajava14taithan.role.exception.InvalidRoleException;
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
	public GroupRoleDto create(GroupRoleDto groupRoleDto) {
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

	@Override
	public GroupRoleDto update(long id, UpdateGroupRoleDto dto) {
		Optional<GroupRole> groupRoleOpt = repository.findById(id);
		if (!groupRoleOpt.isPresent()) {
			throw new InvalidRoleException("Grouprole id is not valid");
		}
		GroupRole groupRole = groupRoleOpt.get();
		
		if (!dto.getName().equals(groupRole.getName())) {
			if (repository.findByName(dto.getName()).isPresent()) {
				throw new InvalidRoleException("Grouprole name is used");
			}
			groupRole.setName(dto.getName());
		}
		
		if (!dto.getCode().equals(groupRole.getCode())) {
			if (repository.findByCode(dto.getCode()).isPresent()) {
				throw new InvalidRoleException("Grouprole code is used");
			}
			groupRole.setCode(dto.getCode());
		}

		groupRole.setDescription(dto.getDescription());
		
		return GroupRoleConverter.toGroupRoleDto(groupRole);
	}

	@Override
	public void delete(long id) {
		Optional<GroupRole> groupRoleOpt = repository.findById(id);
		if (!groupRoleOpt.isPresent()) {
			throw new InvalidRoleException("GroupRole ID is not existed");
		}
		repository.delete(groupRoleOpt.get());
	}
	
	
}
