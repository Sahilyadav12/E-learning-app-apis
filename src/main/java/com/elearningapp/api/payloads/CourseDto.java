package com.elearningapp.api.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private Integer courseId;
    private String category;
    private String subId;
    private String courseName;
   // private String coursetittle;
    private Integer rating;
    private String block;
    private String languageid;
    private String coursecreate;
    private Date validdate;
}
