package com.elearningapp.api.services;


import com.elearningapp.api.entities.Teacher;
import com.elearningapp.api.payloads.TeacherDto;
import com.elearningapp.api.exceptions.ResourceNotFoundException;
import com.elearningapp.api.repositories.TeacherRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.FileStore;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepo teacherRepo;

    private final ModelMapper modelMapper;

    private  StorageService storageService;

    @Value("${project.storage}")
    private String path;



    public TeacherServiceImpl(TeacherRepo teacherRepo, ModelMapper modelMapper, StorageService storageService) {
        this.teacherRepo = teacherRepo;
        this.modelMapper = modelMapper;
        this.storageService = storageService;
    }

    //create
    @Override
    public TeacherDto create(TeacherDto teacherDto){
        Teacher save = modelMapper.map(teacherDto, Teacher.class);
        save.setTeacherId(null);
        String fileName="default.png";
        if(!teacherDto.getProfilePicture().isEmpty()){
            fileName = storageService.uploadBase64File(path, teacherDto.getProfilePicture());
        }
        save.setProfilePicture(fileName);
        return modelMapper.map(teacherRepo.save(save), TeacherDto.class);
    }
    //update
    @Override
    public TeacherDto update(TeacherDto teacherDto, Integer teacherId){
        Teacher teacher=this.teacherRepo.findById(teacherId).
                orElseThrow(()-> new ResourceNotFoundException("Teacher", "teacher",teacherId));

        Teacher update = modelMapper.map(teacherDto, Teacher.class);

        return modelMapper.map(teacherRepo.save(update), TeacherDto.class);

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
