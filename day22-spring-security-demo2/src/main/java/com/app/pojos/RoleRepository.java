package com.app.pojos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByRole(UserRole role);
}
