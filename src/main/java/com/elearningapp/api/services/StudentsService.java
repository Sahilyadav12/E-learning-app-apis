package com.elearningapp.api.services;


import com.elearningapp.api.payloads.StudentsDto;


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
