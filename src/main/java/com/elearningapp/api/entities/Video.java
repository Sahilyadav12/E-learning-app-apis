package com.elearningapp.api.entities;

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
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cvId;
    private String  url;
    private String material;
    private String image;
    private Integer lessonno;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
