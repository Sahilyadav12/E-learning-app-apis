package com.codewithdurgesh.blog.elearningappapis.controllers;
import com.codewithdurgesh.blog.elearningappapis.payloads.VideoDto;
import com.codewithdurgesh.blog.elearningappapis.payloads.ApiResponse;
import com.codewithdurgesh.blog.elearningappapis.services.VideoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/video")
public class Videocontrollers {
    private final VideoService videoService;

    public Videocontrollers(VideoService videoService){
        this.videoService = videoService;
    }
    //post-create teacher
    @PostMapping("/")
    public ResponseEntity<VideoDto> created(@Valid @RequestBody VideoDto videoDto) {
        VideoDto createDto = this.videoService.created(videoDto);
        return new ResponseEntity<>(videoDto, HttpStatus.CREATED);
    }
    //PUT-UPDATE
    @PutMapping("/{videoId}")
    public ResponseEntity<VideoDto> update(@Valid @RequestBody VideoDto videoDto, @PathVariable("videoId") Integer uid) {
        VideoDto update = this.videoService.update(videoDto, uid);
        return ResponseEntity.ok(update);
    }

    //Delete
    @DeleteMapping("/{videoId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("videoId") Integer uid) {
        this.videoService.delete(uid);
        return new ResponseEntity(new ApiResponse("video delete Successfully", true), HttpStatus.OK);
    }
    //Get-teacher get
    @GetMapping("/")
    public ResponseEntity<List<VideoDto>> getAllVideo() {
        return ResponseEntity.ok(this.videoService.getallVideo());
    }

    //Get-user get
    @GetMapping("/{videoId}")
    public ResponseEntity<VideoDto> getSingleVideo(@PathVariable Integer videoId) {
        return ResponseEntity.ok(this.videoService.getVideoById(videoId));
    }

}
