package com.codewithdurgesh.blog.elearningappapis.services;
import com.codewithdurgesh.blog.elearningappapis.entities.Language;
import com.codewithdurgesh.blog.elearningappapis.payloads.LanguageDto;
import com.codewithdurgesh.blog.elearningappapis.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.elearningappapis.repositories.LanguageRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService{

    private final LanguageRepo languageRepo;
    private final ModelMapper modelMapper;

    public LanguageServiceImpl(LanguageRepo languageRepo, ModelMapper modelMapper) {
        this.languageRepo = languageRepo;
        this.modelMapper = modelMapper;
    }
    @Override
    public LanguageDto created(LanguageDto languageDto){
        Language language = new Language();
       language.setId(language.getId());
        language.setLanguagename(language.getLanguagename());
        Language save = languageRepo.save(language);
        return mapToCls(save, LanguageDto.class);
    }
    @Override
    public LanguageDto update(LanguageDto languageDto, Integer languageId)
    {
        return null;
    }
    //delete
    @Override
    public void delete(Integer languageId){
       Language language=this.languageRepo.findById(languageId)
                .orElseThrow(()->new ResourceNotFoundException("Language", "Id",languageId));
        this.languageRepo.delete(language);
    }
    //getTeacherById
    @Override
    public LanguageDto getLanguageById(Integer languageId){
        Language language =this.languageRepo.findById(languageId).orElseThrow(()-> new ResourceNotFoundException("language", "Id", languageId));
        return mapToCls(language,LanguageDto.class);
    }
    //getall user

    public List<LanguageDto> getallLanguage(){
        List<Language> languages = this.languageRepo.findAll();
        List<LanguageDto>languageDtos = languages.stream().map(language -> mapToCls(language,LanguageDto.class)).collect(Collectors.toList());
        return languageDtos;
    }


    private <T,C> C mapToCls(T t, Class<C> c){
        return modelMapper.map(t,c);
    }



}
