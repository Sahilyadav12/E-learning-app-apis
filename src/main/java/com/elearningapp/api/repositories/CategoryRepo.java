package com.elearningapp.api.repositories;

import com.elearningapp.api.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
