package com.elearningapp.api.payloads;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoDto {
    private Integer videoId;
    private String  fileName;
    private String thumbnail;
    private String title;
    private Boolean isBlock;



}
