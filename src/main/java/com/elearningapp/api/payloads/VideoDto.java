package com.elearningapp.api.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideoDto {
    private Integer cvId;
    private String url;
    private String material;
    private String image;
    private Integer courseId;
    private Integer lessonno;


}
