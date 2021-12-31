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

import Cybersoft.javabackend.girajava14taithan.role.dto.RoleDto;
import Cybersoft.javabackend.girajava14taithan.role.dto.UpdateRoleDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "RoleController", description = "Role endpoints") // hien tren swagging
public interface RoleController {

		@Operation(method = "get", description = "get all roles")
		@ApiResponses({
				@ApiResponse(responseCode = "200", description = "get role successfully!"),
				@ApiResponse(responseCode = "403", description = "do not have the correct authorization!")}
				)
		@GetMapping(value = "/roles", produces = "application/json")
		public ResponseEntity<Object> getRoles();
		
		
		@Operation(method = "post", description = "create new role")
		@ApiResponses({
			@ApiResponse(responseCode = "400", description = "invalid role"),
			@ApiResponse(responseCode = "200", description = "role is created")
		})
		@PostMapping(value = "/role")
		public ResponseEntity<Object> createRole(
				@Parameter(description = "role dto") @Valid
				@RequestBody RoleDto dto,
				BindingResult bindingResult
				);
		
		
		@Operation(method = "put", description = "update role")
		@ApiResponses({
			@ApiResponse(responseCode = "400", description = "invalid data"),
			@ApiResponse(responseCode = "200", description = "update role successfully")
		})
		@PutMapping(value = "/role/{id}")
		public ResponseEntity<Object> updateRole(
				@Parameter(description = "role id") @PathVariable("id") long id,
				@Parameter(description = "role dto") @Valid 
				@RequestBody UpdateRoleDto dto, 
				BindingResult bindingResult);
		
		
		@Operation(method = "delete", description = "delete role")
		@ApiResponses({
			@ApiResponse(responseCode = "400", description = "invalid data"),
			@ApiResponse(responseCode = "200", description = "deleted role successfully")
		})
		@DeleteMapping(value = "/role/{id}")
		public ResponseEntity<Object> deleteRole(@Parameter(description = "role id") @PathVariable("id") long id);
}
