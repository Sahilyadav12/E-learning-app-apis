
package com.elearningapp.api.payloads;

import com.elearningapp.api.entities.Course;
import com.elearningapp.api.entities.Teacher;
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
    private Long Id;
    private Teacher teacher;
    private Course course;
}