package com.codewithdurgesh.blog.elearningappapis.controllers;

import com.codewithdurgesh.blog.elearningappapis.payloads.ApiResponse;
import com.codewithdurgesh.blog.elearningappapis.payloads.SubjectDto;
import com.codewithdurgesh.blog.elearningappapis.services.SubjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectControllers {
    private final SubjectService subjectService;

    public SubjectControllers(SubjectService subjectService){
        this.subjectService = subjectService;
    }
    //post-create teacher
    @PostMapping("/")
    public ResponseEntity<SubjectDto> created(@Valid @RequestBody SubjectDto subjectDto) {
        SubjectDto createDto = this.subjectService.created(subjectDto);
        return new ResponseEntity<>(subjectDto, HttpStatus.CREATED);
    }
    //PUT-UPDATE
    @PutMapping("/{subjectId}")
    public ResponseEntity<SubjectDto> update(@Valid @RequestBody SubjectDto subjectDto, @PathVariable("subjectId") Integer uid) {
        SubjectDto update = this.subjectService.update(subjectDto, uid);
        return ResponseEntity.ok(update);
    }

    //Delete
    @DeleteMapping("/{subjectId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("subjectId") Integer uid) {
        this.subjectService.delete(uid);
        return new ResponseEntity(new ApiResponse("subject delete Successfully", true), HttpStatus.OK);
    }
    //Get-teacher get
    @GetMapping("/")
    public ResponseEntity<List<SubjectDto>> getAllSubject() {
        return ResponseEntity.ok(this.subjectService.getallSubject());
    }

    //Get-user get
    @GetMapping("/{subjectId}")
    public ResponseEntity<SubjectDto> getSingleSubject(@PathVariable Integer subjectId) {
        return ResponseEntity.ok(this.subjectService.getSubjectById(subjectId));
    }

}
