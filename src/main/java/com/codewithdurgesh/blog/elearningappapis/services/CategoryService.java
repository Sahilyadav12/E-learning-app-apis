package com.codewithdurgesh.blog.elearningappapis.services;

import com.codewithdurgesh.blog.elearningappapis.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
   CategoryDto created(CategoryDto categoryDto);

    CategoryDto update(CategoryDto categoryDto, Integer categoryId);

    //delete
    void delete(Integer categoryId);

    //getcategorybyId

    CategoryDto getCategoryById(Integer categoryId);

    //get get all User
    List<CategoryDto> getallCategory();

}
