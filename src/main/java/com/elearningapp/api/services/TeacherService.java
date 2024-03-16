package com.elearningapp.api.services;

import com.elearningapp.api.payloads.TeacherDto;

import java.util.List;

public interface TeacherService{
    //create
    TeacherDto create(TeacherDto teacherDto);
    //update
    TeacherDto update(TeacherDto teacherDto, Integer TeacherId);
    //delete
    void delete(Integer TeacherId);
    //getteacherbyId
    TeacherDto getTeacherById(Integer teacherId);

    //get get all User
    List<TeacherDto> getAllTeacher();

}
