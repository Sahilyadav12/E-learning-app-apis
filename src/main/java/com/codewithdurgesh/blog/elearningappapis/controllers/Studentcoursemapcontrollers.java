package com.codewithdurgesh.blog.elearningappapis.controllers;

import com.codewithdurgesh.blog.elearningappapis.entities.Studentcoursemap;
import com.codewithdurgesh.blog.elearningappapis.payloads.ApiResponse;
import com.codewithdurgesh.blog.elearningappapis.payloads.StudentcoursemapDto;
import com.codewithdurgesh.blog.elearningappapis.payloads.StudentsDto;
import com.codewithdurgesh.blog.elearningappapis.services.StudentcoursemapService;
import com.codewithdurgesh.blog.elearningappapis.services.StudentsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Studentcoursemap")
public class Studentcoursemapcontrollers {
    private final StudentcoursemapService studentcoursemapService;

    public Studentcoursemapcontrollers(StudentcoursemapService studentcoursemapService) {
        this.studentcoursemapService = studentcoursemapService;
    }

    //post-create teacher
    @PostMapping("/")
    public ResponseEntity<StudentcoursemapDto> created(@Valid @RequestBody StudentcoursemapDto studentcoursemapDto){
        StudentcoursemapDto createDto = studentcoursemapService.created(studentcoursemapDto);
        return new ResponseEntity<>(createDto, HttpStatus.CREATED);
    }
    //PUT-UPDATE
    @PutMapping("/{studentcoursemapId}")
    public ResponseEntity<StudentcoursemapDto> update (@Valid @RequestBody StudentcoursemapDto studentcoursemapDto, @PathVariable("studentsId") Integer uid){
        StudentcoursemapDto update= this.studentcoursemapService.update(studentcoursemapDto, uid);
        return ResponseEntity.ok(update);
    }
    //Delete
    @DeleteMapping("/{studentcoursemapId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("studentcoursemapId") Integer uid){
        this.studentcoursemapService.delete(uid);
        return new ResponseEntity(new ApiResponse("students delete Successfully",true),HttpStatus.OK);
    }
    //Get-teacher get
    @GetMapping("/")
    public ResponseEntity<List<StudentcoursemapDto>>getAllStudentcoursemap(){
        return ResponseEntity.ok(this.studentcoursemapService.getallStudentcoursemap());
    }
    //Get-user get
    @GetMapping("/{studentcoursemapId}")
    public ResponseEntity<StudentcoursemapDto> getSingleStudentcoursemap(@PathVariable Integer studentcoursemapId )
    {
        return ResponseEntity.ok(this.studentcoursemapService.getStudentcoursemapById(studentcoursemapId));
    }
}
