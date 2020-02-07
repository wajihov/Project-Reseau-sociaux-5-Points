package com.fivePoints.security.domaine;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fivePoints.entities.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	User findByEmail(String email);

	// User findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	User findUserById(Long id);

	@Query("Select u From User u Where u.gender ='Male'")
	List<User> findMale();
	
	@Query("Select u From User u Where u.gender ='Femele'")
	List<User> findFemale();
	
}