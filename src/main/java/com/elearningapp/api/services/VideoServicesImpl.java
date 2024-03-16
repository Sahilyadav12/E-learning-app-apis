package com.elearningapp.api.services;

import com.elearningapp.api.entities.Video;
import com.elearningapp.api.exceptions.ResourceNotFoundException;
import com.elearningapp.api.payloads.VideoDto;
import com.elearningapp.api.repositories.VideoRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoServicesImpl implements VideoService {
    private final VideoRepo videoRepo;

    private final ModelMapper modelMapper;

    public VideoServicesImpl(VideoRepo videoRepo, ModelMapper modelMapper) {
        this.videoRepo = videoRepo;
        this.modelMapper = modelMapper;
    }

    //created
    @Override
    public VideoDto created(VideoDto videoDto) {

        Video video = modelMapper.map(videoDto, Video.class);
        video.setVideoId(null);
        Video save = videoRepo.save(video);
        return mapToCls(save, VideoDto.class);
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
