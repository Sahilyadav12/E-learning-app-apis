package com.elearningapp.api.controllers;

import com.elearningapp.api.payloads.CategoryDto;
import com.elearningapp.api.payloads.ApiResponse;
import com.elearningapp.api.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class Categorycontrollers {
    private final CategoryService categoryService;


    public Categorycontrollers(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    //post-create teacher
    @PostMapping("/")
    public ResponseEntity<CategoryDto> created(@Valid @RequestBody CategoryDto categoryDto) {
       CategoryDto createDto = this.categoryService.created(categoryDto);
        return new ResponseEntity<>(createDto, HttpStatus.CREATED);
    }

    //PUT-UPDATE
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> update(@Valid @RequestBody CategoryDto categoryDto, @PathVariable("categoryId") Integer uid) {
        CategoryDto update = this.categoryService.update(categoryDto, uid);
        return ResponseEntity.ok(update);
    }

    //Delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("categoryId") Integer uid) {
        this.categoryService.delete(uid);
        return new ResponseEntity(new ApiResponse("category delete Successfully", true), HttpStatus.OK);
    }

    //Get-teacher get
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        return ResponseEntity.ok(this.categoryService.getallCategory());
    }

    //Get-user get
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(this.categoryService.getCategoryById(categoryId));
    }


}
