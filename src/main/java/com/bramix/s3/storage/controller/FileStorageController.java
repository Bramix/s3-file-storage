package com.bramix.s3.storage.controller;

import com.bramix.s3.storage.service.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/file")
@RestController
@AllArgsConstructor
public class FileStorageController {

    private final StorageService service;

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadFile(@RequestParam MultipartFile file) {
        service.uploadFile(file);
    }

    @GetMapping(value = "/download/{fileName}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ByteArrayResource downloadFile(@PathVariable String fileName) {
        var byteData = service.downloadFile(fileName);
        return new ByteArrayResource(byteData);
    }

    @DeleteMapping("/delete/{fileName}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFile(@PathVariable String fileName) {
        service.deleteFile(fileName);
    }
}
