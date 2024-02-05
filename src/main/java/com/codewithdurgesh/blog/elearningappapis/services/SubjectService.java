package com.codewithdurgesh.blog.elearningappapis.services;

import com.codewithdurgesh.blog.elearningappapis.payloads.CategoryDto;
import com.codewithdurgesh.blog.elearningappapis.payloads.SubjectDto;

import java.util.List;

public interface SubjectService {
    SubjectDto created(SubjectDto subjectDto);

    SubjectDto update(SubjectDto subjectDto, Integer subjectId);

    //delete
    void delete(Integer subjectId);

    //getcategorybyId

    SubjectDto getSubjectById(Integer subjectId);

    //get get all User
    List<SubjectDto> getallSubject();

}
