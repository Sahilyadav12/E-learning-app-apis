package com.elearningapp.api.controllers;


import com.elearningapp.api.payloads.CourseDto;
import com.elearningapp.api.payloads.ApiResponse;
import com.elearningapp.api.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class Coursecontrollers {
    private final CourseService courseService;


    public Coursecontrollers(CourseService courseService)
    {
        this.courseService = courseService;
    }

    //post-create teacher
    @PostMapping("/")
    public ResponseEntity<CourseDto> created(@Valid @RequestBody CourseDto courseDto) {
        CourseDto createDto = this.courseService.created(courseDto);
        return new ResponseEntity<>(createDto, HttpStatus.CREATED);
    }

    //PUT-UPDATE
    @PutMapping("/{courseId}")
    public ResponseEntity<CourseDto> update(@Valid @RequestBody CourseDto courseDto, @PathVariable("courseId") Integer uid) {
        CourseDto update = this.courseService.update(courseDto, uid);
        return ResponseEntity.ok(update);
    }

    //Delete
    @DeleteMapping("/{courseId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("courseId") Integer uid) {
        this.courseService.delete(uid);
        return new ResponseEntity(new ApiResponse("course delete Successfully", true), HttpStatus.OK);
    }

    //Get-teacher get
    @GetMapping("/")
    public ResponseEntity<List<CourseDto>> getAllCourse() {
        return ResponseEntity.ok(this.courseService.getallCourse());
    }

    //Get-user get
    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDto> getSingleCourse(@PathVariable Integer courseId) {
        return ResponseEntity.ok(this.courseService.getCourseById(courseId));
    }

}
