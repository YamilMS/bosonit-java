package com.example.block11uploaddownloadfiles.Application;

import com.example.block11uploaddownloadfiles.Domain.Fichero;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface FicheroService {

    public void setUploadDir(String uploadDir);
    Fichero storeFile(MultipartFile file, String categoria, String fileType) throws IOException;

    Resource loadFileAsResource(String fileName) throws Exception;
}
