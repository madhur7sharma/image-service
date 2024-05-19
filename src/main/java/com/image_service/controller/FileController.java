package com.image_service.controller;

import com.image_service.entity.File;
import com.image_service.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/test")
    public ResponseEntity<List<Integer>> registerUser() {
        List newList = new ArrayList();
        newList.add(1);
        return new ResponseEntity<>(newList, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> storeFilesInDB(@RequestParam("file") MultipartFile file) throws IOException {
        fileService.storeFile(file);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<byte[]> getFile() {
//        byte[] fileByName = fileService.getFileByName(name);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(fileService.getFileByName("sun_photo"));
//        return null;
    }
}
