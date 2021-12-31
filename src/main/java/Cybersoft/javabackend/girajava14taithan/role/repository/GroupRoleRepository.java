package Cybersoft.javabackend.girajava14taithan.role.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Cybersoft.javabackend.girajava14taithan.role.model.GroupRole;

public interface GroupRoleRepository extends JpaRepository<GroupRole, Long>{

	Optional<GroupRole> findByName(String groupRoleName);

	Optional<GroupRole> findByCode(String groupRoleCode);

}
