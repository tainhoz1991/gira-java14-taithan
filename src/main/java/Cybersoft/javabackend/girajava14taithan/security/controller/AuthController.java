package Cybersoft.javabackend.girajava14taithan.security.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import Cybersoft.javabackend.girajava14taithan.security.dto.LoginDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "loginController", description = "login api")
public interface AuthController {
	
	@Operation(method = "post", description = "user login to get token")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "login successfully!"),
			@ApiResponse(responseCode = "403", description = "incorrect username or password!")}
	)
	@PostMapping(value = "/api/login", produces = "application/json")
	public ResponseEntity<Object> login(@Valid
			@RequestBody LoginDto dto, 
			BindingResult bindingResult
			);
}
