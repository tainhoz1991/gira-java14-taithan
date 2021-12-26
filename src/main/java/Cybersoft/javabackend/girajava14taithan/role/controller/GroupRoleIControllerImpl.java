package Cybersoft.javabackend.girajava14taithan.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import Cybersoft.javabackend.girajava14taithan.role.dto.GroupRoleDto;
import Cybersoft.javabackend.girajava14taithan.role.service.GroupRoleService;

@RestController
public class GroupRoleIControllerImpl implements GroupRoleController{
	private GroupRoleService service;
	
	public GroupRoleIControllerImpl(GroupRoleService service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<List<GroupRoleDto>> getGroupRoleDto() {
		List<GroupRoleDto> groupRoles = service.fillAllGroupRoleDto();
		return new ResponseEntity<>(groupRoles, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createGroupRole(@Valid GroupRoleDto groupRoleDto, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
		
		GroupRoleDto newgroupRoleDto = service.create(groupRoleDto);
		return new ResponseEntity<>(newgroupRoleDto, HttpStatus.CREATED);
	}

}
