package com.elearningapp.api;

import com.elearningapp.api.entities.*;
import com.elearningapp.api.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class ELearningAppApisApplication {

    private LanguageRepo languageRepo;
    private CategoryRepo categoryRepo;
    private TeacherRepo teacherRepo;
    private CourseRepo courseRepo;
    private TeacherCourseMapRepo teacherCourseMapRepo;

    public ELearningAppApisApplication(LanguageRepo languageRepo, CategoryRepo categoryRepo, TeacherRepo teacherRepo, CourseRepo courseRepo, TeacherCourseMapRepo teacherCourseMapRepo) {
        this.languageRepo = languageRepo;
        this.categoryRepo = categoryRepo;
        this.teacherRepo = teacherRepo;
        this.courseRepo = courseRepo;
        this.teacherCourseMapRepo = teacherCourseMapRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(ELearningAppApisApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public WebMvcConfigurer configurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };


    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {

            List ls = new ArrayList<Language>();
            Language hindi = Language.builder().languageId(1).language("HINDI").build();
            Language english = Language.builder().languageId(2).language("ENGLISH").build();
            Language bengali = Language.builder().languageId(3).language("BENGALI").build();
            ls.addAll(List.of(hindi, english, bengali));
            languageRepo.saveAll(ls);

            Category uiUx = Category.builder().Category("UI/UX Design Courses").build();
            Category ad = Category.builder().Category("Art & Design").build();
            Category ce = Category.builder().Category("Computer Science").build();
            Category ha = Category.builder().Category("History & Archeologic").build();
            Category se = Category.builder().Category("Software Engineering").build();
            Category fh = Category.builder().Category("Information Software").build();
            Category hf = Category.builder().Category("Health & Fitness").build();
            Category ma = Category.builder().Category("Marketing").build();
            Category gd = Category.builder().Category("Graphic Design").build();
            Category mu = Category.builder().Category("Music").build();
            Category ba = Category.builder().Category("Business Administration").build();
            Category wm = Category.builder().Category("Web Management").build();

            List cls = List.of(uiUx, ad,ce,ha,se,fh,hf,ma,gd);
            categoryRepo.saveAll(cls);

            Teacher teacher0 = Teacher.builder().teacherId(1).dob(Date.valueOf("1996-02-14")).doj(Date.valueOf(LocalDate.now())).isBlock(false).Email("test@gmail.com").firstName("Sahil").lastName("Yaadav").role("TEACHER").experience(5).password(null).profilePicture(null).qualification("B-Tech").profilePicture("default.avif").language(english).build();
            Teacher teacher1 = Teacher.builder().teacherId(2).dob(Date.valueOf("1996-02-14")).doj(Date.valueOf(LocalDate.now())).isBlock(false).Email("test1@gmail.com").firstName("Sahil").lastName("Yaadav").role("TEACHER").experience(5).password(null).profilePicture(null).qualification("B-Tech").profilePicture("default.avif").language(hindi).build();
            Teacher teacher2 = Teacher.builder().teacherId(3).dob(Date.valueOf("1990-10-20")).doj(Date.valueOf(LocalDate.now())).isBlock(false).Email("test2@gmail.com").firstName("John").lastName("Doe").role("TEACHER").experience(7).password(null).profilePicture(null).qualification("PhD").profilePicture("default.avif").language(english).build();
            Teacher teacher3 = Teacher.builder().teacherId(4).dob(Date.valueOf("1985-05-08")).doj(Date.valueOf(LocalDate.now())).isBlock(true).Email("test3@gmail.com").firstName("Alice").lastName("Smith").role("TEACHER").experience(3).password(null).profilePicture(null).qualification("M.Sc").profilePicture("default.avif").language(bengali).build();
            Teacher teacher4 = Teacher.builder().teacherId(5).dob(Date.valueOf("1992-12-31")).doj(Date.valueOf(LocalDate.now())).isBlock(false).Email("test4@gmail.com").firstName("Emily").lastName("Johnson").role("TEACHER").experience(8).password(null).profilePicture(null).qualification("B.A").profilePicture("default.avif").language(english).build();
            Teacher teacher5 = Teacher.builder().teacherId(6).dob(Date.valueOf("1988-03-25")).doj(Date.valueOf(LocalDate.now())).isBlock(true).Email("test5@gmail.com").firstName("Michael").lastName("Brown").role("TEACHER").experience(6).password(null).profilePicture(null).qualification("B.Sc").profilePicture("default.avif").language(hindi).build();

            List<Teacher> tls = List.of(teacher0, teacher1, teacher2, teacher3, teacher4, teacher5);
            teacherRepo.saveAll(tls);

            Course coreJavaTutorial = Course.builder().courseId(null).title("Core Java Tutorial")
                    .isBlock(true).CreateDate(Date.valueOf(LocalDate.now())).rating(4)
                    .description("this is description of the give course").courseImg("courseDefault.webp")
                    .language(english).category(se).teacher(teacher0).build();
            Course graphicDesign = Course.builder().courseId(null).title("Graphic Design Tutorial")
                    .isBlock(true).CreateDate(Date.valueOf(LocalDate.now())).rating(4)
                    .description("this is description of the give course").courseImg("courseDefault.webp")
                    .language(english).category(se).teacher(teacher0).build();


            courseRepo.saveAll(List.of(coreJavaTutorial,graphicDesign));


        };

    }

}
