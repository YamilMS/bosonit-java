package com.example.block11uploaddownloadfiles.Application;

import com.example.block11uploaddownloadfiles.Domain.Fichero;
import com.example.block11uploaddownloadfiles.Repository.FicheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

    private String uploadDir = "C:\\Users\\yamil.melian\\IdeaProjects\\archivos";

    @Autowired
    public FicheroServiceImpl(FicheroRepository ficheroRepository) {
        this.ficheroRepository = ficheroRepository;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    @Override
    public Fichero storeFile(MultipartFile file, String categoria, String extArchivo) throws IOException {
        //Checkear si el archivo acaba con la extension de archivo pasada
        if (!file.getOriginalFilename().endsWith(extArchivo)) {
            throw new IllegalArgumentException("Tipo de archivo incorrecto.");
        }

        // Crear carpeta destino si no existe
        File carpetaArchivos = new File(uploadDir);
        if (!carpetaArchivos.exists()){
            carpetaArchivos.mkdir();
        }

        // Hacemos el path a la carpeta destino y reemplazamos en caso de que exista
        Path copyLocation = Paths.get(carpetaArchivos.getAbsolutePath() + File.separator + file.getOriginalFilename());
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

        // Aquí nos aseguramos de que estamos creando el Path con la ruta absoluta al directorio
        Path fileLocation = Paths.get(new File(uploadDir).getAbsolutePath()).resolve(fileName).normalize();
        Resource resource = new UrlResource(fileLocation.toUri());

        if(resource.exists()) {
            return resource;
        } else {
            throw new Exception("Archivo no encontrado: " + fileName);
        }
    }

}
