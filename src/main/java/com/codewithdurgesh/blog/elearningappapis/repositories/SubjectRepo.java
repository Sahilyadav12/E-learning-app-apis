package com.codewithdurgesh.blog.elearningappapis.repositories;

import com.codewithdurgesh.blog.elearningappapis.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {
}
