package com.codewithdurgesh.blog.elearningappapis.services;

import com.codewithdurgesh.blog.elearningappapis.entities.Subject;
import com.codewithdurgesh.blog.elearningappapis.entities.Video;
import com.codewithdurgesh.blog.elearningappapis.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.elearningappapis.payloads.SubjectDto;
import com.codewithdurgesh.blog.elearningappapis.payloads.VideoDto;
import com.codewithdurgesh.blog.elearningappapis.repositories.SubjectRepo;
import com.codewithdurgesh.blog.elearningappapis.repositories.VideoRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService{
    private final SubjectRepo subjectRepo;
    private final ModelMapper modelMapper;
    public SubjectServiceImpl ( SubjectRepo subjectRepo, ModelMapper modelMapper){
        this.subjectRepo = subjectRepo;
        this.modelMapper = modelMapper;
    }
    //created
    @Override
    public SubjectDto created(SubjectDto subjectDto){
        Subject subject=new Subject();
        subject.setCouId(subject.getCouId());
        subject.setSubId(subject.getCouId());
        Subject save=subjectRepo.save(subject);
        return mapToCls(save, SubjectDto.class);
    }
    @Override
    public SubjectDto update(SubjectDto subjectDto,Integer subjectId){
        return null;
    }
    @Override
    public void delete(Integer subjectId){
        Subject subject=this.subjectRepo.findById(subjectId)
                .orElseThrow(()->new ResourceNotFoundException("Subject", "Id",subjectId));
        this.subjectRepo.delete(subject);
    }
    //getTeacherById
    @Override
    public SubjectDto getSubjectById(Integer subjectId){
        Subject subject = this.subjectRepo.findById(subjectId).orElseThrow(()-> new ResourceNotFoundException("subject", "Id", subjectId));
        return mapToCls(subject,SubjectDto.class);
    }
    //getall user

    public List<SubjectDto> getallSubject(){
        List<Subject> subject = this.subjectRepo.findAll();
        List<SubjectDto>subjectDtos = subject.stream().map(subjects -> mapToCls(subject,SubjectDto.class)).collect(Collectors.toList());
        return subjectDtos;
    }


    private <T,C> C mapToCls(T t, Class<C> c){
        return modelMapper.map(t,c);
    }

}
