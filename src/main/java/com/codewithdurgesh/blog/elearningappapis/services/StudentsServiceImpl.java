package com.codewithdurgesh.blog.elearningappapis.services;

import com.codewithdurgesh.blog.elearningappapis.entities.Students;
import com.codewithdurgesh.blog.elearningappapis.entities.Teacher;
import com.codewithdurgesh.blog.elearningappapis.payloads.StudentsDto;
import com.codewithdurgesh.blog.elearningappapis.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.elearningappapis.payloads.TeacherDto;
import com.codewithdurgesh.blog.elearningappapis.repositories.StudentsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentsServiceImpl  implements StudentsService{
    private final StudentsRepo studentsRepo;
    private final ModelMapper modelMapper;

    public StudentsServiceImpl(StudentsRepo studentsRepo,ModelMapper modelMapper){
        this.studentsRepo = studentsRepo;
        this.modelMapper = modelMapper;
    }
    //crate
    @Override
    public StudentsDto created(StudentsDto studentsDto){
       var std= modelMapper.map(studentsDto, Students.class);
       std.setId(null);
        return modelMapper.map(studentsRepo.save(std), StudentsDto.class);
    }

    @Override
    public StudentsDto update(StudentsDto studentsDto, Integer studentsId) {
        Students students=this.studentsRepo.findById(studentsId).
                orElseThrow(()-> new ResourceNotFoundException("Students", "students",studentsId));

        var update=modelMapper.map(studentsDto, Students.class);
        update.setId(studentsId);
        return modelMapper.map(studentsRepo.save(update), StudentsDto.class);


    }

    //delete
    @Override
    public void delete(Integer studentsId){
        Students students=this.studentsRepo.findById(studentsId)
                .orElseThrow(()->new ResourceNotFoundException("Students", "Id",studentsId));
        this.studentsRepo.delete(students);
    }
    //getTeacherById
    @Override
    public StudentsDto getStudentsById(Integer studentsId){
        Students students =this.studentsRepo.findById(studentsId).orElseThrow(()-> new ResourceNotFoundException("students", "Id", studentsId));
        return mapToCls(students,StudentsDto.class);
    }
    //getall user

    public List<StudentsDto> getAllStudents(){
        List<Students> students = this.studentsRepo.findAll();
        List<StudentsDto> studentsDtos = students.stream().map(teacher -> mapToCls(students,StudentsDto.class)).collect(Collectors.toList());
        return studentsDtos;
    }


    private <T,C> C mapToCls(T t, Class<C> c){
        return modelMapper.map(t,c);
    }


}
