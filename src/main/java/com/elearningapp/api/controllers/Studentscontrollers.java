package com.elearningapp.api.controllers;


import com.elearningapp.api.payloads.StudentsDto;
import com.elearningapp.api.payloads.ApiResponse;
import com.elearningapp.api.services.StudentsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class Studentscontrollers {

    private final StudentsService studentsService;

    public Studentscontrollers(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    //post-create teacher
    @PostMapping("/")
    public ResponseEntity<StudentsDto> created(@Valid @RequestBody StudentsDto studentsDto){
        StudentsDto createDto = this.studentsService.created(studentsDto);
        return new ResponseEntity<>(createDto, HttpStatus.CREATED);
    }
    //PUT-UPDATE
    @PutMapping("/{studentsId}")
    public ResponseEntity<StudentsDto> update (@Valid @RequestBody StudentsDto studentsDto, @PathVariable("studentsId") Integer uid){
        StudentsDto update= this.studentsService.update(studentsDto, uid);
        return ResponseEntity.ok(update);
    }
    //Delete
    @DeleteMapping("/{studentsId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("studentsId") Integer uid){
        this.studentsService.delete(uid);
        return new ResponseEntity(new ApiResponse("students delete Successfully",true),HttpStatus.OK);
    }
    //Get-teacher get
    @GetMapping("/")
    public ResponseEntity<List<StudentsDto>>getAllStudents(){
        return ResponseEntity.ok(this.studentsService.getAllStudents());
    }
    //Get-user get
    @GetMapping("/{studentsId}")
    public ResponseEntity<StudentsDto> getSingleStudents(@PathVariable Integer studentsId )
    {
        return ResponseEntity.ok(this.studentsService.getStudentsById(studentsId));
    }
}
