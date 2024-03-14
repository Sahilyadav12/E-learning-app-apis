package com.elearningapp.api.entities;

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
    private Integer courseId;
    private String category;
    private String courseName;
    private Integer rating;
    private String block;
    private Date validDate;

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    private Set<TeacherCourseMap> teacherCourseMaps = new LinkedHashSet<>();

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    private Set<Language> languages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    private Set<CourseCategory> categories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    private Set<Video> videos = new LinkedHashSet<>();



}
