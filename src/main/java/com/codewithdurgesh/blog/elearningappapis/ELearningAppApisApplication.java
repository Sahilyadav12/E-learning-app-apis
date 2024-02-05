package com.codewithdurgesh.blog.elearningappapis;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ELearningAppApisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ELearningAppApisApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
