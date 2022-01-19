package Cybersoft.javabackend.girajava14taithan.user.service;


import java.util.Optional;

import Cybersoft.javabackend.girajava14taithan.user.dto.UserDto;
import Cybersoft.javabackend.girajava14taithan.user.model.User;

public interface UserService {
	 User getUserById(long id);

	UserDto create( UserDto dto);

	Optional<User> findByEmail(String email);

	Optional<User> findByUsername(String username);
	 
}
