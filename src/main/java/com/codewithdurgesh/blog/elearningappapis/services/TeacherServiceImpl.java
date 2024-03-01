package com.codewithdurgesh.blog.elearningappapis.services;


import com.codewithdurgesh.blog.elearningappapis.entities.Teacher;
import com.codewithdurgesh.blog.elearningappapis.payloads.TeacherDto;
import com.codewithdurgesh.blog.elearningappapis.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.elearningappapis.repositories.TeacherRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepo teacherRepo;

    private final ModelMapper modelMapper;

    public TeacherServiceImpl(TeacherRepo teacherRepo, ModelMapper modelMapper) {
        this.teacherRepo = teacherRepo;
        this.modelMapper = modelMapper;
    }

    //create
    @Override
    public TeacherDto crate(TeacherDto teacherDto){
        Teacher teacher=new Teacher();
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setBlock(teacherDto.getBlock());
        teacher.setDoB(teacherDto.getDob());
        teacher.setDoJ(teacherDto.getDoj());
        teacher.setExperience(teacherDto.getExperience());
        teacher.setPassword(teacherDto.getPassword());
        teacher.setRole(teacherDto.getRole());
        teacher.setLanguageId(teacherDto.getLanguageId());
        teacher.setQualification(teacherDto.getQualification());
        teacher.setProfilePicture(teacherDto.getProfilePicture());
        Teacher save = teacherRepo.save(teacher);
        return mapToCls(save,TeacherDto.class);
    }
    //update
    @Override
    public TeacherDto update(TeacherDto teacherDto, Integer teacherId){
        Teacher teacher=this.teacherRepo.findById(teacherId).
                orElseThrow(()-> new ResourceNotFoundException("Teacher", "teacher",teacherId));
        teacher.setTeacherId(teacherId);
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setBlock(teacherDto.getBlock());
        teacher.setDoB(teacherDto.getDob());
        teacher.setDoJ(teacherDto.getDoj());
        teacher.setExperience(teacherDto.getExperience());
        teacher.setPassword(teacherDto.getPassword());
        teacher.setRole(teacherDto.getRole());
        teacher.setLanguageId(teacherDto.getLanguageId());
        teacher.setQualification(teacherDto.getQualification());
        teacher.setProfilePicture(teacherDto.getProfilePicture());
        Teacher update = this.teacherRepo.save(teacher);
        TeacherDto teacherDto1 = this.mapToCls(update,TeacherDto.class);
        return teacherDto1;

    }
    //delete
    @Override
    public void delete(Integer teacherId){
        Teacher teacher=this.teacherRepo.findById(teacherId)
                .orElseThrow(()->new ResourceNotFoundException("Teacher", "Id", teacherId));
        this.teacherRepo.delete(teacher);
    }
    //getTeacherById
    @Override
    public TeacherDto getTeacherById(Integer teacherId){
        Teacher teacher=this.teacherRepo.findById(teacherId).orElseThrow(()-> new ResourceNotFoundException("teacher", "Id", teacherId));
        return mapToCls(teacher,TeacherDto.class);
    }

    //getall user

    public List<TeacherDto> getAllTeacher(){
        List<Teacher> teachers = this.teacherRepo.findAll();
        List<TeacherDto> teacherDtos = teachers.stream().map(teacher -> mapToCls(teacher,TeacherDto.class)).collect(Collectors.toList());
        return teacherDtos;
    }


    private <T,C> C mapToCls(T t, Class<C> c){
        return modelMapper.map(t,c);
    }


}
