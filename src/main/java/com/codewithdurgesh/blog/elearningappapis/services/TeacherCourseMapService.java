package com.codewithdurgesh.blog.elearningappapis.services;

import com.codewithdurgesh.blog.elearningappapis.entities.TeacherCourseMap;
import com.codewithdurgesh.blog.elearningappapis.payloads.TeacherCourseMapDto;

import java.util.List;

public interface TeacherCourseMapService {
    TeacherCourseMapDto craeted(TeacherCourseMapDto teacherCourseMapDto);

    //created
    TeacherCourseMapDto created(TeacherCourseMapDto teacherCourseMapDto);
    //update
    TeacherCourseMapDto update(TeacherCourseMapDto teacherCourseMapDto,Integer teacherCourseMapId);
    //delete
    void delete(TeacherCourseMapDto teacherCourseMapDto, Integer teacherCourseMapId);

    //delete
    void delete(Integer teacherCourseMapId);

    //getcategorybyId
    TeacherCourseMapDto getTeacherCourseMapById(Integer teacherCourseMapId);
    //get get all User
    List<TeacherCourseMapDto> getallTeacherCourseMap();
}
