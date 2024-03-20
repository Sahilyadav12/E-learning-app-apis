package com.elearningapp.api.services;


import com.elearningapp.api.entities.Category;
import com.elearningapp.api.entities.Course;
import com.elearningapp.api.entities.Language;
import com.elearningapp.api.entities.Teacher;
import com.elearningapp.api.exceptions.ResourceNotFoundException;
import com.elearningapp.api.payloads.CourseDto;
import com.elearningapp.api.payloads.TeacherDto;
import com.elearningapp.api.repositories.CategoryRepo;
import com.elearningapp.api.repositories.CourseRepo;
import com.elearningapp.api.repositories.LanguageRepo;
import com.elearningapp.api.repositories.TeacherRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepo teacherRepo;
    private final CourseRepo courseRepo;
    private final LanguageRepo languageRepo;
    private final ModelMapper modelMapper;
    private CategoryRepo categoryRepo;
    private StorageService storageService;

    @Value("${project.storage}")
    private String path;


    public TeacherServiceImpl(TeacherRepo teacherRepo, CourseRepo courseRepo, LanguageRepo languageRepo, CategoryRepo categoryRepo, ModelMapper modelMapper, StorageService storageService) {
        this.teacherRepo = teacherRepo;
        this.courseRepo = courseRepo;
        this.languageRepo = languageRepo;
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
        this.storageService = storageService;
    }

    //create
    @Override
    public TeacherDto create(TeacherDto teacherDto) {
        Teacher save = modelMapper.map(teacherDto, Teacher.class);
        save.setTeacherId(null);
        String fileName = "default.png";
        if (!teacherDto.getProfilePicture().isEmpty()) {
            fileName = storageService.uploadBase64File(path, teacherDto.getProfilePicture());
        }
        Language language = languageRepo.findById(teacherDto.getLanguageId()).orElseThrow(() -> new ResourceNotFoundException("language", "language", teacherDto.getLanguageId()));

        save.setProfilePicture(fileName);
        save.setLanguage(language);

        return modelMapper.map(teacherRepo.save(save), TeacherDto.class);
    }

    //update
    @Override
    public TeacherDto update(TeacherDto teacherDto, Integer teacherId) {
        Teacher teacher = this.teacherRepo.findById(teacherId).
                orElseThrow(() -> new ResourceNotFoundException("Teacher", "teacher", teacherId));

        Teacher update = modelMapper.map(teacherDto, Teacher.class);
        update.setTeacherId(teacherId);

        if (!teacherDto.getProfilePicture().isEmpty()) {
            String fileName = storageService.uploadBase64File(path, teacherDto.getProfilePicture());
            update.setProfilePicture(fileName);
        }
        Language language = languageRepo.findById(teacherDto.getLanguageId()).orElseThrow(() -> new ResourceNotFoundException("language", "language", teacherDto.getLanguageId()));
        update.setLanguage(language);


        return modelMapper.map(teacherRepo.save(update), TeacherDto.class);

    }

    //delete
    @Override
    public void delete(Integer teacherId) {
        Teacher teacher = this.teacherRepo.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher", "Id", teacherId));
        this.teacherRepo.delete(teacher);
    }

    //getTeacherById
    @Override
    public TeacherDto getTeacherById(Integer teacherId) {
        Teacher teacher = this.teacherRepo.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("teacher", "Id", teacherId));
        return mapToCls(teacher, TeacherDto.class);
    }

    //getall user

    public List<TeacherDto> getAllTeacher() {
        List<Teacher> teachers = this.teacherRepo.findAll();
        List<TeacherDto> teacherDtos = teachers.stream().map(teacher -> mapToCls(teacher, TeacherDto.class)).collect(Collectors.toList());
        return teacherDtos;
    }

    @Override
    public Set<CourseDto> getCourseByTeacher(Integer teacherId) {
        Teacher teacher = this.teacherRepo.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("teacher", "Id", teacherId));
        return teacher.getCourses().stream().map((element) -> modelMapper.map(element, CourseDto.class)).collect(Collectors.toSet());
    }

    @Override
    public CourseDto addCourseToTeacher(Integer teacherId, CourseDto courseDto) {
        Teacher teacher = this.teacherRepo.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("teacher", "Id", teacherId));
        Course course = modelMapper.map(courseDto, Course.class);
        course.setTeacher(teacher);
        course.setCourseId(null);

        Language language = languageRepo.findById(courseDto.getLanguageId()).orElseThrow(() -> new ResourceNotFoundException("Language", "Id", courseDto.getLanguageId()));
        Category category = categoryRepo.findById(courseDto.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", courseDto.getCategoryId()));

        course.setCategory(category);
        course.setLanguage(language);

        if (!courseDto.getCourseImg().isEmpty()) {
            String imgName = storageService.uploadBase64File(path, courseDto.getCourseImg());
            course.setCourseImg(imgName);

        }


        return modelMapper.map(courseRepo.save(course), CourseDto.class);

    }

    private <T, C> C mapToCls(T t, Class<C> c) {
        return modelMapper.map(t, c);
    }


}
