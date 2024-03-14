package com.elearningapp.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherCourseMap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long TCID;


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
