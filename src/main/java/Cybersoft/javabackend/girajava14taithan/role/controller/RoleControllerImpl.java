package Cybersoft.javabackend.girajava14taithan.role.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import Cybersoft.javabackend.girajava14taithan.role.model.Role;

@RestController
public class RoleControllerImpl implements RoleController{

	@Override
	public ResponseEntity<List<Role>> getRoles() {
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
