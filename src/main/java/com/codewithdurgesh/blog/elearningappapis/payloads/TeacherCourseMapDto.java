package com.codewithdurgesh.blog.elearningappapis.payloads;

import com.codewithdurgesh.blog.elearningappapis.entities.Course;
import com.codewithdurgesh.blog.elearningappapis.entities.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherCourseMapDto {
    private Long TCID;
    private Teacher teacher;
    private Course course;
}
