package Cybersoft.javabackend.girajava14taithan.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cybersoft.javabackend.girajava14taithan.user.dto.UserDto;
import Cybersoft.javabackend.girajava14taithan.user.dto.UserMapper;
import Cybersoft.javabackend.girajava14taithan.user.model.User;
import Cybersoft.javabackend.girajava14taithan.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository repository;
	
	@Override
	public User getUserById(long id) {
		Optional<User> userOpt = repository.findById(id);
		if (userOpt.isPresent()) {
			return userOpt.get();
		}
			
		return null;
	}

	@Override
	public UserDto create(UserDto dto) {
		User user = UserMapper.INSTANCE.userDtoToUser(dto);
		User createUser = repository.save(user);
		return UserMapper.INSTANCE.userToUserDt0(createUser);
	}

}
