package com.codewithdurgesh.blog.elearningappapis.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;
    private String category;
    private String ccId;
    private String coursename;
    //private String courseTittle;
    private Integer fees;
    private Integer rating;
    private String block;
    //private String courseCreate;
    private Date validDate;

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    private Set<TeacherCourseMap> teacherCourseMaps = new LinkedHashSet<>();

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    private Set<Language> languages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    private Set<Category> categories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    private Set<Video> videos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    private Set<Subject> subjects = new LinkedHashSet<>();

}
