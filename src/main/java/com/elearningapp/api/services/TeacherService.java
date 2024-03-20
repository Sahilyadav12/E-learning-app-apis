package com.elearningapp.api.services;

import com.elearningapp.api.payloads.CourseDto;
import com.elearningapp.api.payloads.TeacherDto;

import java.util.List;
import java.util.Set;

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

    Set<CourseDto> getCourseByTeacher(Integer teacherId);
     CourseDto addCourseToTeacher(Integer teacherId,CourseDto courseDto);

}
