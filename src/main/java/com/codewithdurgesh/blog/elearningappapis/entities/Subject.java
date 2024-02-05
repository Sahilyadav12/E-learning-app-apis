package com.codewithdurgesh.blog.elearningappapis.entities;

import com.sun.jdi.PrimitiveValue;
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
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer subId;
    private Integer couId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
