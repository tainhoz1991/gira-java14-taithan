package Cybersoft.javabackend.girajava14taithan.user.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import Cybersoft.javabackend.girajava14taithan.user.model.User;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User userDtoToUser(UserDto dto);
	
	UserDto userToUserDt0(User user);
}
