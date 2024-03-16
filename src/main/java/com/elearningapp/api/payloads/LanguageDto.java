package com.elearningapp.api.payloads;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LanguageDto {
    private Integer languageId;
    private String language;
}
