package com.presidency.petconnect.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public interface StorageService {
    /**
     * Saves the file and returns its stored filename (or URL).
     */
    String store(MultipartFile file);
    @Configuration
    public class WebConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/images/**")
                    .addResourceLocations("file:uploads/");
        }
    }
}
