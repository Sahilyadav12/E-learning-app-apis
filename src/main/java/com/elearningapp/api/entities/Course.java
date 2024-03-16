package com.elearningapp.api.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer courseId;
    private String courseName;
    private Integer rating;
    private boolean block;
    private Date CreateDate;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<TeacherCourseMap> teacherCourseMaps = new LinkedHashSet<>();





    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Video> videos = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
