package com.codewithdurgesh.blog.elearningappapis.repositories;

import com.codewithdurgesh.blog.elearningappapis.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<Video, Integer> {
}
