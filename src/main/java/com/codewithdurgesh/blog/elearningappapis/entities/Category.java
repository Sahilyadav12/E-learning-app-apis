package com.codewithdurgesh.blog.elearningappapis.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private Integer subId;
    private String subjectname;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
