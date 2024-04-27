package com.elearningapp.api.repositories;

import com.elearningapp.api.entities.Course;
import com.elearningapp.api.entities.Teacher;
import com.elearningapp.api.payloads.CourseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CourseRepo extends JpaRepository<Course, Integer> {

//    List<CourseDto> findCoursesByCategoryIsIgnoreCase(String category);


    List<Course> findByCategory_CategoryId(Integer categoryId);
}
