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
    private Integer videoId;
    private String  url;
    private String thumbnail;
    private String title;
    private Boolean isBlock;



}
