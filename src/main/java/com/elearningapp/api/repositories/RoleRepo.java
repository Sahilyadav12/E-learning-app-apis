package com.elearningapp.api.repositories;

import com.elearningapp.api.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
