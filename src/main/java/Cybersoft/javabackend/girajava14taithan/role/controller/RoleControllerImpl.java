package Cybersoft.javabackend.girajava14taithan.role.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import Cybersoft.javabackend.girajava14taithan.role.dto.RoleDto;
import Cybersoft.javabackend.girajava14taithan.role.service.RoleService;

@RestController
public class RoleControllerImpl implements RoleController{
	private RoleService service;
	public RoleControllerImpl(RoleService service) {
		this.service = service;
	}
	
	@Override
	public ResponseEntity<List<RoleDto>> getRoles() {
		List<RoleDto> roles = service.findAllDto();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createRole(RoleDto dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
		
		RoleDto createRole = service.create(dto);
		return new ResponseEntity<>(createRole, HttpStatus.OK);
	}

}
