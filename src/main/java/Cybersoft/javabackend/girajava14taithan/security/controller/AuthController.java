package Cybersoft.javabackend.girajava14taithan.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface AuthController {

	@Operation(method = "post", description = "generate fake token")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "generate fake token successfully!"),
			@ApiResponse(responseCode = "403", description = "do not have the correct authorization!")}
	)
	@PostMapping(value = "/api/fake-token", produces = "application/json")
	public ResponseEntity<Object> createTemporaryToken(
			@RequestParam(value = "username", defaultValue = "taithan") String username);
	
	@Operation(method = "post", description = "verify fake token")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "verify fake token successfully!"),
			@ApiResponse(responseCode = "403", description = "do not have the correct authorization!")}
	)
	@PostMapping(value = "/api/verify-token", produces = "application/json")
	public ResponseEntity<Object> verifyFakeToken(
			@RequestBody String token);
}
