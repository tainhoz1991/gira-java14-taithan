package Cybersoft.javabackend.girajava14taithan.role.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Cybersoft.javabackend.girajava14taithan.role.dto.RoleDto;
import Cybersoft.javabackend.girajava14taithan.role.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query("SELECT r.id as id, r.name as name, r.description as desription FROM Role r")
	List<RoleDto> findAllDto();

	Optional<Role> findByName(String roleName);

	Optional<Role> findByCode(String code);
}
