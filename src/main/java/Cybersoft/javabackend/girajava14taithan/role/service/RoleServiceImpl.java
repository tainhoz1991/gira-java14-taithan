package Cybersoft.javabackend.girajava14taithan.role.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Cybersoft.javabackend.girajava14taithan.role.dto.RoleDto;
import Cybersoft.javabackend.girajava14taithan.role.dto.UpdateRoleDto;
import Cybersoft.javabackend.girajava14taithan.role.exception.InvalidRoleException;
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
//		if (roles.isEmpty()) {
//			throw new NotFoundException("This is for test only!.");
//		}
		
		return RoleConverter.toRoleDtos(roles);
	}

	@Override
	public RoleDto create(RoleDto dto) {
		Role role = RoleConverter.toRole(dto);
		Role createRole = repository.save(role);
		
		return RoleConverter.toRoleDto(createRole);
	}

	@Override
	public Optional<Role> findByName(String roleName) {
		return repository.findByName(roleName);
	}

	@Override
	public Optional<Role> findByCode(String code) {
		return repository.findByCode(code);
	}

	@Override
	public RoleDto updateRole(long id, UpdateRoleDto dto) {
		Optional<Role> roleOpt = repository.findById(id);

		if (!roleOpt.isPresent()) {
			throw new InvalidRoleException("Role id is not valid!.");
		}
		
		// roleOpt.get() la khi ma truong hop tren sai co nghia la
		// roleOpt co gia tri, vi khong co gia tri thi nem Exception va ket thuc
		Role role = roleOpt.get();
		
		if (!role.getName().equals(dto.getName())){
			if (repository.findByName(dto.getName()).isPresent()) {
				throw new InvalidRoleException("Role name has been used!.");
			}
			role.setName(dto.getName());
		}
		
		if (!role.getCode().equals(dto.getCode())){
			if (repository.findByCode(dto.getCode()).isPresent()) {
				throw new InvalidRoleException("Role code has been used!.");
			}
			role.setCode(dto.getCode());
		}
		
		role.setDescription(dto.getDescription());
		
		Role updateRole = repository.save(role);
		
		return RoleConverter.toRoleDto(updateRole);
	}

	@Override
	public void deleteRole(long id) {
		Optional<Role> roleOpt = repository.findById(id);
		if (!roleOpt.isPresent()) {
			throw new InvalidRoleException("Role ID is not existed");
		}
		
		repository.delete(roleOpt.get());
	}

}
