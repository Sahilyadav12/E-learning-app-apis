package com.codewithdurgesh.blog.elearningappapis.repositories;

import com.codewithdurgesh.blog.elearningappapis.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {


}
