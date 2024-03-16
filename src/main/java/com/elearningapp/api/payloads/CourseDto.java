package com.elearningapp.api.payloads;


import com.elearningapp.api.entities.Category;
import com.elearningapp.api.entities.Language;
import com.elearningapp.api.entities.TeacherCourseMap;
import com.elearningapp.api.entities.Video;
import jakarta.persistence.OneToMany;
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
public class CourseDto {    private Integer courseId;
    private String courseName;
    private Integer rating;
    private String block;
    private Date CreateDate;

    private Set<TeacherCourseMap> teacherCourseMaps = new LinkedHashSet<>();

    private Set<LanguageDto> languages = new LinkedHashSet<>();

    private Set<CategoryDto> categories = new LinkedHashSet<>();

    private Set<Video> videos = new LinkedHashSet<>();

}
