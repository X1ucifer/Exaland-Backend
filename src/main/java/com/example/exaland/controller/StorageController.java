package com.example.exaland.controller;

import com.example.exaland.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
public class StorageController {

    @Autowired
    private StorageService service;

    @PostMapping("/upload_video")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "videoData") MultipartFile file) {
        return new ResponseEntity<>(service.uploadFile(file), HttpStatus.OK);
    }
    
    @PostMapping( path = "/image_upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> uploadimage(@RequestParam(value = "videoData") MultipartFile multipartFile) {
    	  return new ResponseEntity<>(service.uploadimage(multipartFile), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        return new ResponseEntity<>(service.deleteFile(fileName), HttpStatus.OK);
    }
}