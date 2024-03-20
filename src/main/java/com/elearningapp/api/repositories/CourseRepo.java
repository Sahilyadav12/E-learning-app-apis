package com.elearningapp.api.repositories;

import com.elearningapp.api.entities.Course;
import com.elearningapp.api.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CourseRepo extends JpaRepository<Course, Integer> {




}
