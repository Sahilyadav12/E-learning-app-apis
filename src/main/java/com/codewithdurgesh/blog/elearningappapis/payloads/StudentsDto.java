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
public class StudentsDto {

    private Integer Id;
    private String name;
    private String email;
    private Integer password;
    private  Integer mobile;
    private Date DoB;
    private String profilepicture;
    private String reg;


}
