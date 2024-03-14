package com.elearningapp.api.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public interface StorageService {
    public Resource getFileAsResource(String path,String fileName);
    public InputStream downloadFile(String path, String fileName);
    public String uploadFile(String path,MultipartFile file) ;

    }
