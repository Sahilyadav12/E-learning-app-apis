package com.elearningapp.api.repositories;

import com.elearningapp.api.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {
}
