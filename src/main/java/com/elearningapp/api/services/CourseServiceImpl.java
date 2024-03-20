package com.elearningapp.api.services;


import com.elearningapp.api.entities.Course;
import com.elearningapp.api.entities.Teacher;
import com.elearningapp.api.payloads.CourseDto;
import com.elearningapp.api.exceptions.ResourceNotFoundException;
import com.elearningapp.api.repositories.CourseRepo;
import com.elearningapp.api.repositories.TeacherRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
   private  final TeacherRepo teacherRepo;
    private final ModelMapper modelMapper;

    public CourseServiceImpl(CourseRepo courseRepo, TeacherRepo teacherRepo, ModelMapper modelMapper) {
        this.courseRepo = courseRepo;
        this.teacherRepo = teacherRepo;
        this.modelMapper = modelMapper;
    }

    //crate
    @Override
    public CourseDto created(CourseDto courseDto) {
//        Course course = new Course();
//        course.setCourseId(course.getCourseId());
//        course.setCategory(course.getCategory());
//        course.setBlock(course.getCategory());
//        course.setRating(course.getRating());
//        course.setCourseName(course.getCourseName());
//        Course save = courseRepo.save(course);
//        return mapToCls(save, CourseDto.class);

        return null;
    }

    @Override
    public CourseDto update(CourseDto courseDto, Integer courseId) {
        return null;
    }
    //delete
    @Override
    public void delete(Integer courseId){
        Course course=this.courseRepo.findById(courseId)
                .orElseThrow(()->new ResourceNotFoundException("Course", "Id",courseId));
        this.courseRepo.delete(course);
    }
    //getTeacherById
    @Override
    public CourseDto getCourseById(Integer courseId){
        Course course =this.courseRepo.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("course", "Id", courseId));
        return mapToCls(course,CourseDto.class);
    }
    //getall user

    public List<CourseDto> getallCourse(){
        return courseRepo.findAll().stream().map((element) -> modelMapper.map(element, CourseDto.class)).collect(Collectors.toList());
    }



    private <T,C> C mapToCls(T t, Class<C> c){
        return modelMapper.map(t,c);
    }


}
