package com.codewithdurgesh.blog.elearningappapis.services;

import com.codewithdurgesh.blog.elearningappapis.entities.TeacherCourseMap;
import com.codewithdurgesh.blog.elearningappapis.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.elearningappapis.payloads.TeacherCourseMapDto;
import com.codewithdurgesh.blog.elearningappapis.repositories.TeacherCourseMapRepo;
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
    public TeacherCourseMapDto craeted(TeacherCourseMapDto teacherCourseMapDto){
        TeacherCourseMap teacherCourseMap = new TeacherCourseMap();
        teacherCourseMap.setCourse(teacherCourseMap.getCourse());
        teacherCourseMap.setTCID(teacherCourseMap.getTCID());
        teacherCourseMap.setTeacher(teacherCourseMap.getTeacher());
        TeacherCourseMap save = teacherCourseMapRepo.save(teacherCourseMap);
        return mapToCls(save, TeacherCourseMapDto.class);
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

    //delete
    @Override
    public void delete(Integer teacherCourseMapId){
        TeacherCourseMap teacherCourseMap=this.teacherCourseMapRepo.findById(teacherCourseMapId)
                .orElseThrow(()->new ResourceNotFoundException("teacherCourseMap", "Id",teacherCourseMapId));
        this.teacherCourseMapRepo.delete(teacherCourseMap);
    }
    //getTeacherById
    @Override
    public TeacherCourseMapDto getTeacherCourseMapById(Integer teacherCourseMapId){
        TeacherCourseMap teacherCourseMap1  = this.teacherCourseMapRepo.findById(teacherCourseMapId)
                .orElseThrow(()-> new ResourceNotFoundException("teacherCourseMap", "Id", teacherCourseMapId));
        return mapToCls(teacherCourseMap1,TeacherCourseMapDto.class);
    }
    //getall user

    public List<TeacherCourseMapDto> getallTeacherCourseMap(){
        List<TeacherCourseMap> teacherCourseMaps = this.teacherCourseMapRepo.findAll();
        List<TeacherCourseMapDto>teacherCourseMapDtos = teacherCourseMaps.stream().map(teacherCourseMap -> mapToCls(teacherCourseMap,TeacherCourseMapDto.class)).collect(Collectors.toList());
        return teacherCourseMapDtos;
    }


    private <T,C> C mapToCls(T t, Class<C> c){
        return modelMapper.map(t,c);
    }


}
