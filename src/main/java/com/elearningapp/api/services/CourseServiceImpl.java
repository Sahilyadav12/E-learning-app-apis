package com.elearningapp.api.services;


import com.elearningapp.api.entities.Course;
import com.elearningapp.api.payloads.CourseDto;
import com.elearningapp.api.exceptions.ResourceNotFoundException;
import com.elearningapp.api.repositories.CourseRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    public CourseServiceImpl(CourseRepo courseRepo, ModelMapper modelMapper) {
        this.courseRepo = courseRepo;
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
        List<Course> courses = this.courseRepo.findAll();
        List<CourseDto>courseDtos = courses.stream().map(course -> mapToCls(courses,CourseDto.class)).collect(Collectors.toList());
        return courseDtos;
    }


    private <T,C> C mapToCls(T t, Class<C> c){
        return modelMapper.map(t,c);
    }


}
