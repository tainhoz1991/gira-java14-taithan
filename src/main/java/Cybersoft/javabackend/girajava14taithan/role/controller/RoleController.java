package Cybersoft.javabackend.girajava14taithan.role.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import Cybersoft.javabackend.girajava14taithan.role.model.Role;
import io.swagger.v3.oas.annotations.Operation;
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
		public ResponseEntity<List<Role>> getRoles();
}
