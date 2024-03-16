package com.elearningapp.api.services;

import com.elearningapp.api.entities.TeacherCourseMap;
import com.elearningapp.api.exceptions.ResourceNotFoundException;
import com.elearningapp.api.payloads.TeacherCourseMapDto;
import com.elearningapp.api.repositories.TeacherCourseMapRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherCourseMapServiceImpl implements TeacherCourseMapService{
    private final TeacherCourseMapRepo teacherCourseMapRepo;
    private final ModelMapper modelMapper;

    public TeacherCourseMapServiceImpl(TeacherCourseMapRepo teacherCourseMapRepo, ModelMapper modelMapper) {
        this. teacherCourseMapRepo =  teacherCourseMapRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public TeacherCourseMapDto created(TeacherCourseMapDto teacherCourseMapDto) {
        return null;
    }

    @Override
    public TeacherCourseMapDto update(TeacherCourseMapDto teacherCourseMapDto, Integer teacherCourseMapId) {
        return null;
    }

    @Override
    public void delete(TeacherCourseMapDto teacherCourseMapDto, Integer teacherCourseMapId) {

    }

    @Override
    public void delete(Integer teacherCourseMapId) {

    }

    @Override
    public TeacherCourseMapDto getTeacherCourseMapById(Integer teacherCourseMapId) {
        return null;
    }

    @Override
    public List<TeacherCourseMapDto> getallTeacherCourseMap() {
        return null;
    }

    private <T,C> C mapToCls(T t, Class<C> c){
        return modelMapper.map(t,c);
    }


}
