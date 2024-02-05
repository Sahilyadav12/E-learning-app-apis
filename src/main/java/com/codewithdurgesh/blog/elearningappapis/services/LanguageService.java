package com.codewithdurgesh.blog.elearningappapis.services;

import com.codewithdurgesh.blog.elearningappapis.payloads.LanguageDto;

import java.util.List;

public interface LanguageService {
    LanguageDto created(LanguageDto languageDto);

    LanguageDto update(LanguageDto languageDto, Integer languagaeId);

    //delete
    void delete(Integer  languageId);

    //getlanguagebyId

    LanguageDto getLanguageById(Integer  languageId);

    //get get all User
    List<LanguageDto> getallLanguage();

}
