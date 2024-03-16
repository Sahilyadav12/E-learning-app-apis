package com.elearningapp.api.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer teacherId;
    private String firstName;
    private String lastName;
    private String Email;
    private Integer password;
    private Boolean isBlock;
    private Date dob;
    private String qualification;
    private Date doj;
    private Integer experience;
    private String role;
    private String profilePicture;

    @OneToMany(mappedBy = "teacher", orphanRemoval = true,cascade = CascadeType.ALL)
    private Set<TeacherCourseMap> teacherCourseMaps = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

}
