
package com.elearningapp.api.payloads;

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