package com.elearningapp.api.repositories;

import com.elearningapp.api.entities.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CourseCategory, Integer> {

}
