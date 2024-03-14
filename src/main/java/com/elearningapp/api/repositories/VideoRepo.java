package com.elearningapp.api.repositories;

import com.elearningapp.api.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<Video, Integer> {
}
