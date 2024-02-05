package com.codewithdurgesh.blog.elearningappapis.services;

import com.codewithdurgesh.blog.elearningappapis.entities.Studentcoursemap;
import com.codewithdurgesh.blog.elearningappapis.entities.Students;
import com.codewithdurgesh.blog.elearningappapis.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.elearningappapis.payloads.StudentcoursemapDto;
import com.codewithdurgesh.blog.elearningappapis.payloads.StudentsDto;
import com.codewithdurgesh.blog.elearningappapis.repositories.StudentcoursemapRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentcoursemapServiceImpl implements StudentcoursemapService {
    private final StudentcoursemapRepo studentcoursemapRepo;

    private final ModelMapper modelMapper;

    public StudentcoursemapServiceImpl(StudentcoursemapRepo studentcoursemapRepo, ModelMapper modelMapper) {
        this.studentcoursemapRepo = studentcoursemapRepo;
        this.modelMapper = modelMapper;
    }

    //create
    @Override
    public StudentcoursemapDto created(StudentcoursemapDto studentcoursemapDto){
        Studentcoursemap studentcoursemap = new Studentcoursemap();
        studentcoursemap.setCourseId(studentcoursemap.getCourseId());
        studentcoursemap.setStudentId(studentcoursemap.getCourseId());
        Studentcoursemap save = studentcoursemapRepo.save(studentcoursemap);
        return mapToCls(save, StudentcoursemapDto.class);
    }
    @Override
    public StudentcoursemapDto update(StudentcoursemapDto studentcoursemapDto, Integer studentcoursemapId) {
        return null;
    }

    //delete
    @Override
    public void delete(Integer studentcoursemapId){
        Studentcoursemap studentcoursemap=this.studentcoursemapRepo.findById(studentcoursemapId)
                .orElseThrow(()->new ResourceNotFoundException("Students", "Id",studentcoursemapId));
        this.studentcoursemapRepo.delete(studentcoursemap);
    }
    //getTeacherById
    @Override
    public StudentcoursemapDto getStudentcoursemapById(Integer studentcoursemapId){
       Studentcoursemap studentcoursemap =this.studentcoursemapRepo.findById(studentcoursemapId).orElseThrow(()-> new ResourceNotFoundException("studentcoursemap", "Id", studentcoursemapId));
        return mapToCls(studentcoursemap,StudentcoursemapDto.class);
    }
    //getall user

    public List<StudentcoursemapDto> getallStudentcoursemap(){
        List<Studentcoursemap> studentcoursemaps = this.studentcoursemapRepo.findAll();
        List<StudentcoursemapDto> studentcoursemapDtoS = studentcoursemaps.stream().map(studentcoursemap -> mapToCls(studentcoursemaps, StudentcoursemapDto.class)).toList();
        return studentcoursemapDtoS;
    }


    private <T,C> C mapToCls(T t, Class<C> c){
        return modelMapper.map(t,c);
    }


}
