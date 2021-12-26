package Cybersoft.javabackend.girajava14taithan.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import Cybersoft.javabackend.girajava14taithan.role.dto.GroupRoleDto;
import io.swagger.v3.oas.annotations.Operation;
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
	public ResponseEntity<List<GroupRoleDto>> getGroupRoleDto();
	
	@Operation(method = "post", description = "create new group role")
	@ApiResponses({
			@ApiResponse(responseCode = "400", description = "invalid group role"),
			@ApiResponse(responseCode = "200", description = "group role is created")}
	)
	@PostMapping(value = "/grouprole")
	public ResponseEntity<Object> createGroupRole(@Valid 
			@RequestBody GroupRoleDto groupRoleDto, BindingResult bindingResult
			);
}
