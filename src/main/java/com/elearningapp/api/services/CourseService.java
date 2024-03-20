package com.elearningapp.api.services;

import com.elearningapp.api.entities.Teacher;
import com.elearningapp.api.payloads.CourseDto;

import java.util.List;
import java.util.Set;

public interface CourseService  {
    CourseDto created(CourseDto courseDto);
    CourseDto update(CourseDto courseDto, Integer courseId);

    //delete
    void delete(Integer courseId);

    //getStudentsbyId

    CourseDto getCourseById(Integer courseId);

    //get get all User
    List<CourseDto> getallCourse();



}
