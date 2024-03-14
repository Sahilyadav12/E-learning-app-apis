package com.elearningapp.api.payloads;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

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
    private Boolean block;
    private Date dob;
    private String language;
    private String qualification;
    private Date doj;
    private Integer experience;
    private String role;
    private String profilePicture;

}
