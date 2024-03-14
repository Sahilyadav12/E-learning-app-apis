package com.elearningapp.api.services;

import com.elearningapp.api.payloads.SubjectDto;

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
