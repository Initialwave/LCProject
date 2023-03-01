package com.example.demo.Models.data;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

    public class StorageService {

        void init(){};

        public void store(MultipartFile file){};

        public Stream<Path> loadAll(){return null;};

        public Path load(String filename){ return null;};

        public Resource loadAsResource(String filename){return null;};

        void deleteAll(){};

    }

