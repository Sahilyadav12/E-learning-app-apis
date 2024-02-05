package com.codewithdurgesh.blog.elearningappapis.controllers;

import com.codewithdurgesh.blog.elearningappapis.payloads.TeacherDto;
import com.codewithdurgesh.blog.elearningappapis.payloads.ApiResponse;
import com.codewithdurgesh.blog.elearningappapis.services.TeacherService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class Teachercontrollers {
    private final TeacherService teacherService;

    public Teachercontrollers(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    //post-create teacher
    @PostMapping("/")
    public ResponseEntity<TeacherDto> create(@Valid @RequestBody TeacherDto teacherDto){
        TeacherDto createDto = this.teacherService.crate(teacherDto);
        return new ResponseEntity<>(createDto, HttpStatus.CREATED);
    }
    //PUT-UPDATE
    @PutMapping("/{teacherId}")
    public ResponseEntity<TeacherDto> update (@Valid @RequestBody TeacherDto teacherDto, @PathVariable("teacherId") Integer uid){
        TeacherDto update= this.teacherService.update(teacherDto, uid);
        return ResponseEntity.ok(update);
    }
    //Delete
    @DeleteMapping("/{teacherId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("teacherId") Integer uid){
        this.teacherService.delete(uid);
        return new ResponseEntity(new ApiResponse("Teacher delete Successfully",true),HttpStatus.OK);
    }
    //Get-teacher get
    @GetMapping("/")
    public ResponseEntity<List<TeacherDto>>getAllTeacher(){
        return ResponseEntity.ok(this.teacherService.getAllTeacher());
    }
    //Get-user get
    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherDto> getSingleTeacher(@PathVariable Integer teacherId)
    {
        return ResponseEntity.ok(this.teacherService.getTeacherById(teacherId));
    }


}
