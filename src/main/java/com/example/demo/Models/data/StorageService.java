package com.example.demo.Models.data;

import com.example.demo.File;
import com.example.demo.Models.StorageException;
import com.example.demo.Models.StorageFileNotFoundException;
import com.mysql.cj.util.StringUtils;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

    @Service
    public class StorageService {

        @Autowired
        private FilesRepository filesRepository;




        public File store(MultipartFile file){
            String fileName = String.valueOf(StringUtils.isNullOrEmpty(file.getOriginalFilename()));


            try {
                if(fileName.contains("..")) {
                    throw new StorageException("Sorry! Filename contains invalid path sequence " + fileName);
                }
                File dbfile = new File(fileName, file.getContentType(), file.getBytes());

                return filesRepository.save(dbfile);
            } catch(IOException ex) {
                throw new StorageException("Could not store file " + fileName + ". Please try again!", ex);
            }
        };

        public File getFile(String fileId) {
            return filesRepository.findById(fileId).orElseThrow(()-> new StorageFileNotFoundException("File not found with ID " + fileId));
        };

    }

