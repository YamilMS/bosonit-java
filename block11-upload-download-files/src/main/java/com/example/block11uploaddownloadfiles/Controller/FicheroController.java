package com.example.block11uploaddownloadfiles.Controller;

import com.example.block11uploaddownloadfiles.Application.FicheroService;
import com.example.block11uploaddownloadfiles.Domain.Fichero;
import com.example.block11uploaddownloadfiles.Repository.FicheroRepository;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@RestController
public class FicheroController {

    private final FicheroRepository ficheroRepository;

    private final FicheroService ficheroService;

    @Autowired
    public FicheroController(FicheroRepository ficheroRepository, FicheroService fileStorageService) {
        this.ficheroRepository = ficheroRepository;
        this.ficheroService = fileStorageService;
    }

    @PostMapping("/upload/{tipo}")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,
                                        @RequestParam String categoria,
                                        @PathVariable String tipo) throws IOException {
        Fichero fichero = ficheroService.storeFile(file, categoria, tipo);
        return ResponseEntity.ok(fichero);
    }

    @GetMapping("/file")
    public ResponseEntity<Resource> downloadFile(@RequestParam(required = false) Long id,
                                               @RequestParam(required = false) String nombre) throws Exception {
        Fichero fichero;
        if (id != null) {
            fichero = ficheroRepository.findById(id).orElse(null);
        } else if (nombre != null) {
            fichero = ficheroRepository.findByNombreFichero(nombre);
        } else {
            ByteArrayResource emptyResource = new ByteArrayResource(new byte[0]);
            return ResponseEntity.badRequest().body(emptyResource);
        }

        if (fichero == null) {
            return ResponseEntity.notFound().build();
        }

        Resource resource = ficheroService.loadFileAsResource(fichero.getNombreFichero());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fichero.getNombreFichero())
                .body(resource);
    }

    @GetMapping("/setpath")
    public ResponseEntity<String> setPath(@RequestParam String path) {
        ficheroService.setUploadDir(path);
        return ResponseEntity.ok("Directorio de subida actualizado a: " + path);
    }
}
