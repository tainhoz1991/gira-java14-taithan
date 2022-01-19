package Cybersoft.javabackend.girajava14taithan.user.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import Cybersoft.javabackend.girajava14taithan.user.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "userController", description = "user api")
public interface UserController {

	@Operation(method = "get", description = "get all users")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "get user successfully!"),
			@ApiResponse(responseCode = "403", description = "do not have the correct authorization!")}
			)
	@GetMapping(value = "/api/users", produces = "application/json")
	public ResponseEntity<Object> getUsers();
	
	
	@Operation(method = "post", description = "create new user")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "invalid user"),
		@ApiResponse(responseCode = "200", description = "role is created")
	})
	@PostMapping(value = "/api/users")
	public ResponseEntity<Object> createUser(
			@Parameter(description = "user dto") @Valid
			@RequestBody UserDto dto,
			BindingResult bindingResult
			);
}
