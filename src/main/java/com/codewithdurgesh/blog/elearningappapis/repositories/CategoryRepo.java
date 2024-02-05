package com.codewithdurgesh.blog.elearningappapis.repositories;

import com.codewithdurgesh.blog.elearningappapis.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
