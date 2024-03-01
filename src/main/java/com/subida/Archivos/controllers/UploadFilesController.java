package com.subida.Archivos.controllers;

import org.springframework.http.HttpStatus;
import com.subida.Archivos.services.IUploadFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadFilesController {

    @Autowired
    IUploadFilesService uploadFilesService;

    @PostMapping("/picture")
    private ResponseEntity<String> uploadPic(@RequestPart("file") MultipartFile file) throws Exception {
        return new ResponseEntity<>(uploadFilesService.handleFileUpload(file),HttpStatus.OK);




    }

}
