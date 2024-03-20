package com.elearningapp.api.payloads;


import com.elearningapp.api.entities.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private Integer courseId;
    private String title;
    private String description;
//    private Integer rating;
    private Boolean isBlock;
    private Date createDate;

    private Integer languageId;
    private String language;


    private Integer categoryId;
    private String category;

    private String courseImg;


    private Set<VideoDto> videos = new LinkedHashSet<>();


}
