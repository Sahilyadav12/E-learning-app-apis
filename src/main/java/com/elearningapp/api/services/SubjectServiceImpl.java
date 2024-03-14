package com.elearningapp.api.services;

import com.elearningapp.api.entities.Subject;
import com.elearningapp.api.exceptions.ResourceNotFoundException;
import com.elearningapp.api.payloads.SubjectDto;
import com.elearningapp.api.repositories.SubjectRepo;
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
        subject.setSubName(subjectDto.getSubName());
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

    public List<SubjectDto> getallSubject(){
        List<Subject> subject = this.subjectRepo.findAll();
        List<SubjectDto>subjectDtos = subject.stream().map(subjects -> mapToCls(subject,SubjectDto.class)).collect(Collectors.toList());
        return subjectDtos;
    }


    private <T,C> C mapToCls(T t, Class<C> c){
        return modelMapper.map(t,c);
    }

}
