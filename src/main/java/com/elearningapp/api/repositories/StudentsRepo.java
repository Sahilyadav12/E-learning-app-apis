package com.elearningapp.api.repositories;

import com.elearningapp.api.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepo extends JpaRepository<Students, Integer> {

}
