package com.codewithdurgesh.blog.elearningappapis.services;
import com.codewithdurgesh.blog.elearningappapis.entities.Video;
import com.codewithdurgesh.blog.elearningappapis.payloads.VideoDto;
import com.codewithdurgesh.blog.elearningappapis.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.elearningappapis.repositories.VideoRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoServicesImpl implements VideoService {
    private final VideoRepo videoRepo;

    private final ModelMapper modelMapper;

    public VideoServicesImpl(VideoRepo videoRepo, ModelMapper modelMapper){
        this.videoRepo = videoRepo;
        this.modelMapper = modelMapper;
    }
    //created
    @Override
    public VideoDto created(VideoDto videoDto){
        Video video = new Video();
       // video.setCourseId(video.getCourseId());
        video.setLessonno(video.getLessonno());
        video.setImage(video.getImage());
        video.setCvId(video.getCvId());
        video.setUrl(video.getUrl());
        video.setMaterial(video.getMaterial());
        Video save = videoRepo.save(video);
        return mapToCls(save, VideoDto.class);
    }
    @Override
    public VideoDto update(VideoDto videoDto,Integer videoId){
        return null;
    }
    @Override
    public void delete(Integer videoId){
        Video video=this.videoRepo.findById(videoId)
                .orElseThrow(()->new ResourceNotFoundException("Course", "Id",videoId));
        this.videoRepo.delete(video);
    }
    //getTeacherById
    @Override
    public VideoDto getVideoById(Integer videoId){
        Video video =this.videoRepo.findById(videoId).orElseThrow(()-> new ResourceNotFoundException("video", "Id", videoId));
        return mapToCls(video,VideoDto.class);
    }
    //getall user

    public List<VideoDto> getallVideo(){
        List<Video> videos = this.videoRepo.findAll();
        List<VideoDto>videoDtos = videos.stream().map(video -> mapToCls(videos,VideoDto.class)).collect(Collectors.toList());
        return videoDtos;
    }


    private <T,C> C mapToCls(T t, Class<C> c){
        return modelMapper.map(t,c);
    }


}
