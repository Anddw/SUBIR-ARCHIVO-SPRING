package com.subida.Archivos.services.impl;

import com.subida.Archivos.services.IUploadFilesService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


@Service
public class IUploadFilesServiceImpl implements IUploadFilesService {
    @Override
    public String handleFileUpload(MultipartFile file) throws Exception {
        try {
            String fileName = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileOriginalName = file.getOriginalFilename();

            long filesize = file.getSize();
            long macFileSize = 5 * 1024 * 1024;

           if (filesize > macFileSize){
return  "File size must be less then or equal 5MB";
           }


           if (
                   !fileOriginalName.endsWith(".jpg")&&
                    !fileOriginalName.endsWith(".jpeg")&&
                    !fileOriginalName.endsWith(".png")
           ){
               return "only jpg , jpeg , png files are allowed!";

           }

           String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
           String newFileName = file + fileExtension;

            File folder = new File("src/main/resources/picture");
            if (!folder.exists()){
                folder.mkdirs();
            }

           Path Path = Paths.get("src/main/resources/picture/" + newFileName);
            Files.write(Path,bytes);
            return "File upload seccesfully";


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
