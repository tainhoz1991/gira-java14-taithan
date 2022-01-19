package Cybersoft.javabackend.girajava14taithan.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Cybersoft.javabackend.girajava14taithan.user.dto.UserDto;
import Cybersoft.javabackend.girajava14taithan.user.dto.UserMapper;
import Cybersoft.javabackend.girajava14taithan.user.model.User;
import Cybersoft.javabackend.girajava14taithan.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private PasswordEncoder encoder;
	
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
		user.setPassword(encoder.encode(dto.getPassword()));
		
		User createUser = repository.save(user);
		createUser.setPassword(null);
		
		return UserMapper.INSTANCE.userToUserDt0(createUser);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return repository.findByUsername(username);
	}

}
