package com.elearningapp.api.controllers;

import com.elearningapp.api.payloads.LanguageDto;
import com.elearningapp.api.payloads.ApiResponse;
import com.elearningapp.api.services.LanguageService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/language")
public class Languagecontrollers {
    private final LanguageService languageService;


    public Languagecontrollers(LanguageService languageService) {
        this.languageService = languageService;
    }

    //post-create teacher
    @PostMapping()
    public ResponseEntity<LanguageDto> created(@Valid @RequestBody LanguageDto languageDto) {
       LanguageDto createDto = this.languageService.created(languageDto);
        return new ResponseEntity<>(createDto, HttpStatus.CREATED);
    }

    //PUT-UPDATE
    @PutMapping("/{languageId}")
    public ResponseEntity<LanguageDto> update(@Valid @RequestBody LanguageDto languageDto, @PathVariable("languageId") Integer uid) {
        LanguageDto update = this.languageService.update(languageDto, uid);
        return ResponseEntity.ok(update);
    }

    //Delete
    @DeleteMapping("/{languageId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("languageId") Integer uid) {
        this.languageService.delete(uid);
        return new ResponseEntity(new ApiResponse("language delete Successfully", true), HttpStatus.OK);
    }

    //Get-teacher get
    @GetMapping()
    public ResponseEntity<List<LanguageDto>> getAllLanguage() {
        return ResponseEntity.ok(this.languageService.getallLanguage());
    }

    //Get-user get
    @GetMapping("/{languageId}")
    public ResponseEntity<LanguageDto> getSingleLanguage(@PathVariable Integer languageId) {
        return ResponseEntity.ok(this.languageService.getLanguageById(languageId));
    }


}
