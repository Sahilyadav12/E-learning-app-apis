package com.codewithdurgesh.blog.elearningappapis.services;

import com.codewithdurgesh.blog.elearningappapis.payloads.CourseDto;
import com.codewithdurgesh.blog.elearningappapis.payloads.StudentcoursemapDto;

import java.util.List;

public interface StudentcoursemapService {

    StudentcoursemapDto created(StudentcoursemapDto studentcoursemapDto);

    StudentcoursemapDto update(StudentcoursemapDto studentcoursemapDto, Integer studentcoursemapId);

    //delete
    void delete(Integer studentcoursemapId);

    //getStudentsbyId

    StudentcoursemapDto getStudentcoursemapById(Integer studentcoursemapId);

    //get get all User
    List<StudentcoursemapDto> getallStudentcoursemap();

}
