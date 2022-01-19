package Cybersoft.javabackend.girajava14taithan.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Cybersoft.javabackend.girajava14taithan.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.groups WHERE username = ?1")
	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);

}
