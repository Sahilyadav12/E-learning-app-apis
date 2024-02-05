package com.codewithdurgesh.blog.elearningappapis.services;

import com.codewithdurgesh.blog.elearningappapis.payloads.TeacherDto;

import java.util.List;

public interface TeacherService{
    //create
    TeacherDto crate(TeacherDto teacherDto);
    //update
    TeacherDto update(TeacherDto teacherDto, Integer TeacherId);
    //delete
    void delete(Integer TeacherId);
    //getteacherbyId
    TeacherDto getTeacherById(Integer teacherId);

    //get get all User
    List<TeacherDto> getAllTeacher();

}
