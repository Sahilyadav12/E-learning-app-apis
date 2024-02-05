package com.codewithdurgesh.blog.elearningappapis.services;

import com.codewithdurgesh.blog.elearningappapis.entities.Category;
import com.codewithdurgesh.blog.elearningappapis.payloads.CategoryDto;
import com.codewithdurgesh.blog.elearningappapis.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.elearningappapis.repositories.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepo categoryRepo, ModelMapper modelMapper) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }
    @Override
    public CategoryDto created(CategoryDto categoryDto){
        Category category = new Category();
        category.setId(category.getId());
        category.setSubId(category.getSubId());
        category.setSubjectname(category.getSubjectname());
        Category save = categoryRepo.save(category);
        return mapToCls(save, CategoryDto.class);
    }
    @Override
    public CategoryDto update(CategoryDto categoryDto, Integer categoryId) {
        return null;
    }
    //delete
    @Override
    public void delete(Integer categoryId){
        Category category=this.categoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category", "Id",categoryId));
        this.categoryRepo.delete(category);
    }
    //getTeacherById
    @Override
    public CategoryDto getCategoryById(Integer categoryId){
        Category category =this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category", "Id", categoryId));
        return mapToCls(category,CategoryDto.class);
    }
    //getall user

    public List<CategoryDto> getallCategory(){
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto>categoryDtos = categories.stream().map(category -> mapToCls(category,CategoryDto.class)).collect(Collectors.toList());
        return categoryDtos;
    }


    private <T,C> C mapToCls(T t, Class<C> c){
        return modelMapper.map(t,c);
    }



}
