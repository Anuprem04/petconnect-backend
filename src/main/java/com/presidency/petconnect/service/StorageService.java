package com.presidency.petconnect.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    /**
     * Saves the file and returns its stored filename (or URL).
     */
    String store(MultipartFile file);
}
