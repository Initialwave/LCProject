package com.example.demo;

import com.example.demo.Models.data.StorageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebApplicationConfig {
    //@Bean
    public StorageService storageService(){
        return new StorageService();
    }
}
