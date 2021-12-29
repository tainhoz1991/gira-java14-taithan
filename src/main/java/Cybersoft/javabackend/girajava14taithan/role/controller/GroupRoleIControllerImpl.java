package Cybersoft.javabackend.girajava14taithan.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import Cybersoft.javabackend.girajava14taithan.commo.ResponeHandler;
import Cybersoft.javabackend.girajava14taithan.role.dto.GroupRoleDto;
import Cybersoft.javabackend.girajava14taithan.role.service.GroupRoleService;

@RestController
public class GroupRoleIControllerImpl implements GroupRoleController{
	private GroupRoleService service;
	
	public GroupRoleIControllerImpl(GroupRoleService service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<Object> getGroupRoleDto() {
		List<GroupRoleDto> groupRoles = service.fillAllGroupRoleDto();
		return ResponeHandler.getRespone(groupRoles, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createGroupRole(@Valid GroupRoleDto groupRoleDto, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return ResponeHandler.getRespone(bindingResult, HttpStatus.BAD_REQUEST);
		
		GroupRoleDto newgroupRoleDto = service.create(groupRoleDto);
		return ResponeHandler.getRespone(newgroupRoleDto, HttpStatus.CREATED);
	}

}
