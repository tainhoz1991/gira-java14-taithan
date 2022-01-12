package Cybersoft.javabackend.girajava14taithan;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import Cybersoft.javabackend.girajava14taithan.user.dto.UserDto;
import Cybersoft.javabackend.girajava14taithan.user.dto.UserMapper;
import Cybersoft.javabackend.girajava14taithan.user.model.User;

public class UserMapperTest {
	@Test
	public void shouldMapUserDtoToUser() {
		UserDto dto = new UserDto();
		dto.setUsername("user123");
		dto.setEmail("example@example.com");
		dto.setPassword("1234");
		dto.setFullname("example");
		
		User user = UserMapper.INSTANCE.userDtoToUser(dto);
		
		assertThat(user.getUsername().equals(dto.getUsername()));
		assertThat(user.getEmail().equals(dto.getEmail()));
		assertThat(user.getPassword().equals(dto.getPassword()));
		assertThat(user.getFullname().equals(dto.getFullname()));
	}
	
	@Test
	public void shouldMapUserToUserDto() {
		User user = new User();
		user.setUsername("user123");
		user.setEmail("example@example.com");
		user.setPassword("1234");
		user.setFullname("example");
		
		UserDto dto = UserMapper.INSTANCE.userToUserDt0(user);
		
		assertThat(user.getUsername().equals(dto.getUsername()));
		assertThat(user.getEmail().equals(dto.getEmail()));
		assertThat(user.getPassword().equals(dto.getPassword()));
		assertThat(user.getFullname().equals(dto.getFullname()));
	}
}
