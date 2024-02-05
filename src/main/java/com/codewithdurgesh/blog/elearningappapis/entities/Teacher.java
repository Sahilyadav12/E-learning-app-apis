package com.codewithdurgesh.blog.elearningappapis.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer teacherId;
    private String firstName;
    private String lastName;
    private String Email;
    private Integer password;
    private Boolean block;
    private Date DoB;
    private String languageId;
    private Integer qualification;
    private Date DoJ;
    private Integer experience;
    private String role;
    private String profilePicture;

    @OneToMany(mappedBy = "teacher", orphanRemoval = true)
    private Set<TeacherCourseMap> teacherCourseMaps = new LinkedHashSet<>();

}
