package com.elearningapp.api.services;

import com.elearningapp.api.entities.Course;
import com.elearningapp.api.entities.Video;
import com.elearningapp.api.exceptions.ResourceNotFoundException;
import com.elearningapp.api.payloads.VideoDto;
import com.elearningapp.api.repositories.CourseRepo;
import com.elearningapp.api.repositories.VideoRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoServicesImpl implements VideoService {
    private final VideoRepo videoRepo;

    private final ModelMapper modelMapper;
    private final StorageService storageService;
    private  final CourseRepo courseRepo;




    public VideoServicesImpl(VideoRepo videoRepo, ModelMapper modelMapper, StorageService storageService, CourseRepo courseRepo) {
        this.videoRepo = videoRepo;
        this.modelMapper = modelMapper;
        this.storageService = storageService;
        this.courseRepo = courseRepo;
    }

    @Value("${project.storage}")
    private String path;


    @Override
    public void created(int courseId, MultipartFile thumbnail, MultipartFile video) {
        Course course =this.courseRepo.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("course", "Id", courseId));

        String thumbName = storageService.uploadFile(path, thumbnail);
        String videoName = storageService.uploadFile(path, video);


        var videoEntity=Video.builder().videoId(null).fileName(videoName)
                .thumbnail(thumbName).course(course)
                .build();
        videoRepo.save(videoEntity);
    }

    @Override
    public VideoDto update(VideoDto videoDto, Integer videoId) {
        Video video = this.videoRepo.findById(videoId).orElseThrow(() -> new ResourceNotFoundException("Course", "Id", videoId));
        Video update = modelMapper.map(videoDto, Video.class);
        update.setVideoId(videoId);
        update.setVideoId(null);
        return modelMapper.map(videoRepo.save(update), VideoDto.class);
    }

    @Override
    public void delete(Integer videoId) {
        Video video = this.videoRepo.findById(videoId).orElseThrow(() -> new ResourceNotFoundException("Course", "Id", videoId));
        this.videoRepo.delete(video);
    }

    //getTeacherById
    @Override
    public VideoDto getVideoById(Integer videoId) {
        return modelMapper.map(this.videoRepo.findById(videoId)
                .orElseThrow(() -> new ResourceNotFoundException("video", "Id", videoId)), VideoDto.class);
    }

    public List<VideoDto> getallVideo() {
        return this.videoRepo.findAll().stream().map((element) -> modelMapper.map(element, VideoDto.class)).collect(Collectors.toList());
    }


    private <T, C> C mapToCls(T t, Class<C> c) {
        return modelMapper.map(t, c);
    }


}
