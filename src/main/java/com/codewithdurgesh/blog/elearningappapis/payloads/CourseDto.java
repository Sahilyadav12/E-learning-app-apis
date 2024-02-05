package com.codewithdurgesh.blog.elearningappapis.payloads;


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
    private Integer ID;
    private String category;
    private String ccId;
    private String subId;
    private String coursename;
    private String coursetittle;
    private Integer fees;
    private Integer rating;
    private String block;
    private String languageid;
    private String coursecreate;
    private Date validdate;
}
