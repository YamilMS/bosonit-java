package com.example.block11uploaddownloadfiles.Repository;

import com.example.block11uploaddownloadfiles.Domain.Fichero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FicheroRepository extends JpaRepository<Fichero, Long> {
    Fichero findByNombreFichero(String nombreFichero);
}
