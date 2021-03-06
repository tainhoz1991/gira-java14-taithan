package Cybersoft.javabackend.girajava14taithan.role.controller;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import Cybersoft.javabackend.girajava14taithan.role.dto.GroupRoleDto;
import Cybersoft.javabackend.girajava14taithan.role.dto.UpdateGroupRoleDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "GroupRoleController", description = "GroupRole endpoints")
public interface GroupRoleController {
	
	@Operation(method = "get", description = "get all GroupRole")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "get group role successfully!"),
			@ApiResponse(responseCode = "403", description = "do not have the correct authorization!")}
	)
	@GetMapping(value = "/grouproles", produces = "application/json")
	public ResponseEntity<Object> getGroupRoleDto();
	
	@Operation(method = "post", description = "create new group role")
	@ApiResponses({
			@ApiResponse(responseCode = "400", description = "invalid group role"),
			@ApiResponse(responseCode = "200", description = "group role is created")}
	)
	@PostMapping(value = "/grouprole")
	public ResponseEntity<Object> createGroupRole(@Valid 
			@RequestBody GroupRoleDto groupRoleDto, BindingResult bindingResult
			);
	
	
	@Operation(method = "put", description = "update group role")
	@ApiResponses({
			@ApiResponse(responseCode = "400", description = "invalid group role"),
			@ApiResponse(responseCode = "200", description = "update group role is successfully")}
	)
	@PutMapping(value = "/grouprole/{id}")
	public ResponseEntity<Object> updateGroupRole(
			@Parameter(description = "group role id") @PathVariable("id") long id,
			@Parameter(description = "group role dto") @Valid 
			@RequestBody UpdateGroupRoleDto dto, 
			BindingResult bindingResult
			);
	
	
	@Operation(method = "delete", description = "delete group role")
	@ApiResponses({
			@ApiResponse(responseCode = "400", description = "invalid group role"),
			@ApiResponse(responseCode = "200", description = "deleted role is successfully")}
	)
	@DeleteMapping(value = "/grouprole/{id}")
	public ResponseEntity<Object> deleteGroupRole(
			@Parameter(description = "grouprole id") @PathVariable("id") long id
			);
	
}
