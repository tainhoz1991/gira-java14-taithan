package Cybersoft.javabackend.girajava14taithan.role.controller;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import Cybersoft.javabackend.girajava14taithan.role.dto.RoleDto;
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
}
