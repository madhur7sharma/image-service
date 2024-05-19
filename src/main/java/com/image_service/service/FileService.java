package com.image_service.service;

import com.image_service.entity.File;
import com.image_service.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepo;

    public void storeFile(MultipartFile file) throws IOException {
        File fileToBeUploaded = File.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(file.getBytes())
                .build();
        fileRepo.save(fileToBeUploaded);

        if(fileToBeUploaded.getId() != null) {
        }
    }

    public byte[] getFileByName(String name) {
        return fileRepo.findByName(name).getImageData();
    }
}
