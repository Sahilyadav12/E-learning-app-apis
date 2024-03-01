
package com.codewithdurgesh.blog.elearningappapis.payloads;

import com.codewithdurgesh.blog.elearningappapis.entities.Course;
import com.codewithdurgesh.blog.elearningappapis.entities.Teacher;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherCourseMapDto {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long TCID;
    private Long teacher;
    private Long course;
}