package com.example.block11uploaddownloadfiles.Application;

import com.example.block11uploaddownloadfiles.Domain.Fichero;
import com.example.block11uploaddownloadfiles.Repository.FicheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class FicheroServiceImpl implements FicheroService {

    private final FicheroRepository ficheroRepository;

    private String uploadDir = "C:\\Users\\yamil.melian\\IdeaProjects";

    @Autowired
    public FicheroServiceImpl(FicheroRepository ficheroRepository) {
        this.ficheroRepository = ficheroRepository;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    @Override
    public Fichero storeFile(MultipartFile file, String categoria, String fileType) throws IOException {

        if (!file.getOriginalFilename().endsWith(fileType)) {
            throw new IllegalArgumentException("Tipo de archivo incorrecto.");
        }

        Path copyLocation = Paths.get(uploadDir + file.getOriginalFilename());
        Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);

        Fichero fichero = new Fichero();
        fichero.setNombreFichero(file.getOriginalFilename());
        fichero.setFechaSubida(LocalDate.from(LocalDateTime.now()));
        fichero.setCategoria(categoria);

        ficheroRepository.save(fichero);

        return fichero;
    }

    @Override
    public Resource loadFileAsResource(String fileName) throws Exception {
        Path fileLocation = Paths.get(uploadDir + fileName);
        Resource resource = new UrlResource(fileLocation.toUri());

        if (resource.exists()) {
            return resource;
        } else {
            throw new Exception("Archivo no encontrado.");
        }
    }
}
