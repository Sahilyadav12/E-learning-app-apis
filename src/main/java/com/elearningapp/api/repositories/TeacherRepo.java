package com.elearningapp.api.repositories;

import com.elearningapp.api.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher,Integer> {

}
