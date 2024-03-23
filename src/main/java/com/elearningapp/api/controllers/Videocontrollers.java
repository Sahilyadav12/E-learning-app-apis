package com.elearningapp.api.controllers;

import com.elearningapp.api.payloads.ApiResponse;
import com.elearningapp.api.payloads.VideoDto;
import com.elearningapp.api.services.StorageService;
import com.elearningapp.api.services.VideoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/upload")
public class Videocontrollers {
    private final VideoService videoService;
    private final StorageService storageService;

    public Videocontrollers(VideoService videoService, StorageService storageService) {
        this.videoService = videoService;
        this.storageService = storageService;
    }


    //post-create teacher
    @PostMapping("/course/{courseId}/video")
    public ResponseEntity<VideoDto> created(
            @PathVariable("courseId") int courseId,
            @RequestParam("thumbnail") MultipartFile thumbnail, @RequestParam("video") MultipartFile video) {

        videoService.created(courseId,thumbnail,video);



        return null;
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
    @GetMapping()
    public ResponseEntity<List<VideoDto>> getAllVideo() {
        return ResponseEntity.ok(this.videoService.getallVideo());
    }

    //Get-user get
    @GetMapping("/{videoId}")
    public ResponseEntity<VideoDto> getSingleVideo(@PathVariable Integer videoId) {
        return ResponseEntity.ok(this.videoService.getVideoById(videoId));
    }

}
