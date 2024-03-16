package com.elearningapp.api.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;
    private String Category;


    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private Set<Course> courses = new LinkedHashSet<>();

}
