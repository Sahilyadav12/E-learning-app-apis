package com.codewithdurgesh.blog.elearningappapis.repositories;

import com.codewithdurgesh.blog.elearningappapis.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepo extends JpaRepository<Students, Integer> {

}
