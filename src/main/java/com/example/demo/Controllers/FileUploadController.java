package com.example.demo.Controllers;

import com.example.demo.Models.UploadFileResponse;
import com.example.demo.File;
import com.example.demo.Models.StorageFileNotFoundException;
import com.example.demo.Models.UploadFileResponse;
import com.example.demo.Models.data.StorageService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;



@RestController
public class FileUploadController {

   // public final Logger logger = (Logger) LoggerFactory.getLogger(FileUploadController.class);
    @Autowired
    private StorageService storageService;

  @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
      File dbFile = storageService.store(file);

      String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
              .path("/downloadFile/")
              .path(dbFile.getId())
              .toUriString();

      return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
              file.getContentType(), file.getSize());
  }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        File dbFile = storageService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }
}