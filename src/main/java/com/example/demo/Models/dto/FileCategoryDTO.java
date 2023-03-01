package com.example.demo.Models.dto;


//import javax.validation.constraints.NotNull;
import jakarta.validation.constraints.NotNull;

import java.io.File;


public class FileCategoryDTO {

    @NotNull
    private File file;


    public FileCategoryDTO(){}

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
