package com.codewithdurgesh.blog.elearningappapis.controllers;

import com.codewithdurgesh.blog.elearningappapis.payloads.ApiResponse;
import com.codewithdurgesh.blog.elearningappapis.payloads.TeacherCourseMapDto;
import com.codewithdurgesh.blog.elearningappapis.services.TeacherCourseMapService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacherCourseMap")
public class TeacherCourseMapcontrollers {
    private final TeacherCourseMapService teacherCourseMapService;

    public TeacherCourseMapcontrollers(TeacherCourseMapService teacherCourseMapService){
        this.teacherCourseMapService = teacherCourseMapService;
    }
    //post-created
    @PostMapping("/")
    public ResponseEntity<TeacherCourseMapDto> created(@Valid @RequestBody TeacherCourseMapDto teacherCourseMapDto){
        TeacherCourseMapDto createDto = this.teacherCourseMapService.created(teacherCourseMapDto);
        return new ResponseEntity<>(teacherCourseMapDto, HttpStatus.CREATED);
    }
    //put-update
  @PutMapping("/{teacherCourseMapId}")
public ResponseEntity<TeacherCourseMapDto> update(@Valid @RequestBody TeacherCourseMapDto teacherCourseMapDto,@PathVariable("teacherCourseMapId") Integer uid){
    TeacherCourseMapDto update = this.teacherCourseMapService.update(teacherCourseMapDto, uid);
    return ResponseEntity.ok(update);
}
// //Delete
@DeleteMapping("/{teacherCourseMapId}")
public ResponseEntity<ApiResponse> delete(@PathVariable("teacherCourseMapId") Integer uid){
    this.teacherCourseMapService.delete(uid);
    return new ResponseEntity(new ApiResponse("teacherCourseMap delete is successfully", true), HttpStatus.OK);
    }
    //get-teacherCoursemap
    @GetMapping("/")
    public ResponseEntity<List<TeacherCourseMapDto>> getAllTeacherCourseMap(){
        return ResponseEntity.ok(this.teacherCourseMapService.getallTeacherCourseMap());
    }
    //Get-teacherCourseMap
    public ResponseEntity<TeacherCourseMapDto> getSingleTeacherCourseMap(@PathVariable Integer teacherCourseMapId){
        return ResponseEntity.ok(this.teacherCourseMapService.getTeacherCourseMapById(teacherCourseMapId));
    }
}

