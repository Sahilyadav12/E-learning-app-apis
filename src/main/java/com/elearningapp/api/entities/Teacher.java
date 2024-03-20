package com.elearningapp.api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer teacherId;
    private String firstName;
    private String lastName;
    private String Email;
    private Integer password;
    private Boolean isBlock;
    private Date dob;
    private String qualification;
    private Date doj;
    private Integer experience;
    private String role;
    private String profilePicture;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;


    @OneToMany(mappedBy = "teacher", orphanRemoval = true)
    private Set<Course> courses = new LinkedHashSet<>();

}
