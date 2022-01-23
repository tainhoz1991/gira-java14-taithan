package Cybersoft.javabackend.girajava14taithan.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import Cybersoft.javabackend.girajava14taithan.commo.ResponeHandler;
import Cybersoft.javabackend.girajava14taithan.role.dto.GroupRoleDto;
import Cybersoft.javabackend.girajava14taithan.role.dto.RoleDto;
import Cybersoft.javabackend.girajava14taithan.role.service.GroupRoleService;

@RestController
public class GroupControllerImpl implements GroupController{
	
	@Autowired
	private GroupRoleService service;
	
	@Override
	public ResponseEntity<Object> findGroups() {
		List<GroupRoleDto> groups = service.fillAllGroupRoleDto();
		
		return ResponeHandler.getRespone(groups, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> create(@Valid GroupRoleDto dto, BindingResult result) {
		if (result.hasErrors()) {
			return ResponeHandler.getErrorRespone(result, HttpStatus.BAD_REQUEST);
		}
		
		GroupRoleDto newgroupRoleDto = service.create(dto);
		return ResponeHandler.getRespone(newgroupRoleDto, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Object> addUser(long groupId, long userId) {
		service.addUser(groupId, userId);
		return ResponeHandler.getRespone(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> removeUser(long groupId, long userId) {
		service.removeUser(groupId, userId);
		return ResponeHandler.getRespone(HttpStatus.OK);
	}

}
