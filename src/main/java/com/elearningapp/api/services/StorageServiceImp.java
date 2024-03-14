package com.elearningapp.api.services;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class StorageServiceImp implements StorageService {





   @Override
    public String uploadFile(String path,MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new IllegalArgumentException("Invalid file name: " + fileName);
            }
            String generatedFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
            Path targetLocation = Paths.get(path).resolve(generatedFileName);
            Files.copy(file.getInputStream(), targetLocation);
            return generatedFileName;
        } catch (IOException ex) {
            throw new RuntimeException("Failed to store file " + fileName, ex);
        }
    }


    @Override
    public Resource getFileAsResource(String path,String fileName) {
        try {
            Path filePath = Paths.get(path).resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("File not found: " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new RuntimeException("File not found: " + fileName, ex);
        }
    }

    @Override
    public InputStream downloadFile(String path, String fileName) {
        var localFilePath=path+File.separator+fileName;
        var localFile=new File(localFilePath);
        try {
            var fileInputStream=new FileInputStream(localFile);
            return fileInputStream;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
