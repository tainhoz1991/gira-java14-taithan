package Cybersoft.javabackend.girajava14taithan.role.service;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import Cybersoft.javabackend.girajava14taithan.role.dto.RoleDto;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
@Transactional
public class RoleServiceTest {
	/* Coverage 
	 * ti le dong code can test bao nhieu
	 * % so voi toan bo */
	@Autowired
	private RoleService service;
	
	@BeforeAll
	public void setupTest() {
		RoleDto dto = RoleDto.builder()
				.code("TFF")
				.name("TEST")
				.description("TEST DESCRIPTION")
				.build();
		RoleDto result = service.create(dto);
		//assertNotEquals(service.create(dto), null);
	}
	
	@Test
	public void shouldLoadRoleServiceNormally() {
		assertNotEquals(service, null);
	}

	@Test
	public void shouldFoundDtos() {
		List<RoleDto> dtos = service.findAllDto();
		
		assertNotEquals(dtos.size(), 0);
	}
}
