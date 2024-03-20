package com.elearningapp.api.payloads;

import com.elearningapp.api.entities.Course;
import com.elearningapp.api.entities.Language;
import com.elearningapp.api.entities.TeacherCourseMap;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {




    private Integer teacherId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer password;
    private Boolean isBlock;
    private Date dob;
    private String language;
    private Integer languageId;
    private String qualification;
    private Date doj;
    private Integer experience;
    private String role;
    private String profilePicture;


}
