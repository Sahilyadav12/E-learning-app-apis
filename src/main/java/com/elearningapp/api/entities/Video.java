package com.elearningapp.api.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer videoId;
    private String  fileName;
    private String thumbnail;
    private String title;
    private Boolean isBlock;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
