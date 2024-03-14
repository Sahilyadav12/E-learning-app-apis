package com.elearningapp.api.repositories;

import com.elearningapp.api.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {


}
