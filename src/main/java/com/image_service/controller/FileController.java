package com.image_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FileController {

    @GetMapping("/get")
    public ResponseEntity<List<Integer>> registerUser() {
        List newList = new ArrayList();
        newList.add(1);
        return new ResponseEntity<>(newList, HttpStatus.OK);
    }
}
