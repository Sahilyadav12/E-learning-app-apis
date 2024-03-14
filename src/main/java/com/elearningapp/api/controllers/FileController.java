package com.elearningapp.api.controllers;

import com.elearningapp.api.services.StorageService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/file")
public class FileController {

    final StorageService storageService;
    @Value("${project.storage}")
    private String path;
    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping()
    public ResponseEntity<Map<String,String>> uploadVideo(@RequestParam("file") MultipartFile file) throws IOException {
        String fName = storageService.uploadFile(path,file);
        var hashMap = new HashMap<String,String>();
        hashMap.put("message","Uploaded Successfully");
        hashMap.put("File Name",fName);
//        ApiResponse api = ApiResponse.builder().message("Done").success(true).build();
        return new ResponseEntity<>(hashMap,HttpStatus.OK);
    }

    @GetMapping(value = "/{fileName}",produces = MediaType.ALL_VALUE)
    public void downloadFile(@PathVariable("fileName") String fileName, HttpServletResponse response) {

        InputStream inputStream = storageService.downloadFile(path, fileName);
        response.setContentType(MediaType.ALL_VALUE);
        try {
            StreamUtils.copy(inputStream,response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}