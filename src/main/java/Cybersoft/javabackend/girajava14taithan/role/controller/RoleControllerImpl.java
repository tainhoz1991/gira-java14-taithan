package Cybersoft.javabackend.girajava14taithan.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import Cybersoft.javabackend.girajava14taithan.commo.ResponeHandler;
import Cybersoft.javabackend.girajava14taithan.role.dto.RoleDto;
import Cybersoft.javabackend.girajava14taithan.role.dto.UpdateRoleDto;
import Cybersoft.javabackend.girajava14taithan.role.service.RoleService;

@RestController
public class RoleControllerImpl implements RoleController{
	private RoleService service;
	public RoleControllerImpl(RoleService service) {
		this.service = service;
	}
	
	@Override
	public ResponseEntity<Object> getRoles() {
		List<RoleDto> roles = service.findAllDto();
		return ResponeHandler.getRespone(roles, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createRole(RoleDto dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponeHandler.getErrorRespone(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		RoleDto createRole = service.create(dto);
		
		// test thu
//		if (createRole != null) {
//			return new ResponseEntity<Object>(HttpStatus.BAD_GATEWAY);
//		}
		
		return ResponeHandler.getRespone(createRole, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> updateRole(long id, @Valid UpdateRoleDto dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponeHandler.getErrorRespone(bindingResult, HttpStatus.BAD_REQUEST);
		}
		RoleDto updateRole = service.updateRole(id, dto);
		
		return ResponeHandler.getRespone(updateRole, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteRole(long id) {
		service.deleteRole(id);
		return ResponeHandler.getRespone("Deleted role successfully", HttpStatus.OK);
	}

}
