package com.example.demo.Models.data;

import com.example.demo.File;
import com.example.demo.Models.StorageException;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

    @Service
    @Deprecated
    public class StorageService {

        @Autowired
        private FilesRepository filesRepository;


        public File store(MultipartFile file){
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

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

        public Stream<Path> loadAll(){return null;};

        public Path load(String filename){ return null;};

        public Resource loadAsResource(String filename){return null;};

        void deleteAll(){};

    }

