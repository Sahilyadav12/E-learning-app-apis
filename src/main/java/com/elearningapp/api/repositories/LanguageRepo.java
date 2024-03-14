package com.elearningapp.api.repositories;

import com.elearningapp.api.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepo extends JpaRepository<Language, Integer>{
}
