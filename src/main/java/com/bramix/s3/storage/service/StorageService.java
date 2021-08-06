package com.bramix.s3.storage.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    boolean uploadFile(MultipartFile file);

    byte[] downloadFile(String fileName);

    void deleteFile(String fileName);

}
