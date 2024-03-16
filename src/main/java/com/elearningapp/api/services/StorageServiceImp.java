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
import java.util.Base64;
import java.util.UUID;

@Service
public class StorageServiceImp implements StorageService {


    @Override
    public String uploadFile(String path, MultipartFile file) {
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
    public Resource getFileAsResource(String path, String fileName) {
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
        var localFilePath = path + File.separator + fileName;
        var localFile = new File(localFilePath);
        try {
            var fileInputStream = new FileInputStream(localFile);
            return fileInputStream;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String uploadBase64File(String path, String base64Data) {
//        String ext = base64Data.substring(base64Data.indexOf("/") + 1, base64Data.indexOf(";"));
//        byte[] data = Base64.getDecoder().decode(base64Data);

        byte[] imageBytes = Base64.getDecoder().decode(base64Data.split(",")[1]);

        var file = new File(path + File.separator + UUID.randomUUID().toString() + ".png");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(imageBytes);
            fos.close();
            return file.getName();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
