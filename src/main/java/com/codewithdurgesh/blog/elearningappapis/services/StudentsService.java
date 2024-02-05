package com.codewithdurgesh.blog.elearningappapis.services;


import com.codewithdurgesh.blog.elearningappapis.payloads.StudentsDto;


import java.util.List;

public interface StudentsService {
    //create
    StudentsDto created(StudentsDto studentsDto);

    //update

    StudentsDto update(StudentsDto studentsDto, Integer studentsId);

    //delete
    void delete(Integer studentsId);

    //getStudentsbyId

    StudentsDto getStudentsById(Integer studentsId);

    //get get all User
    List<StudentsDto> getAllStudents();

}
