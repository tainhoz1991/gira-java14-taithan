package Cybersoft.javabackend.girajava14taithan.user.service;


import Cybersoft.javabackend.girajava14taithan.user.dto.UserDto;
import Cybersoft.javabackend.girajava14taithan.user.model.User;

public interface UserService {
	 User getUserById(long id);

	UserDto create( UserDto dto);
	 
}
