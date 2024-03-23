package com.elearningapp.api.services;

import com.elearningapp.api.payloads.VideoDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VideoService {
//    VideoDto created(VideoDto videoDto);

    VideoDto update(VideoDto videoDto, Integer courseId);

    //delete
    void delete(Integer videoId);

    //getVideosbyId

    VideoDto getVideoById(Integer  videoId);

    //get get all User
    List< VideoDto> getallVideo();


    void created(int courseId, MultipartFile thumbnail, MultipartFile video);
}
