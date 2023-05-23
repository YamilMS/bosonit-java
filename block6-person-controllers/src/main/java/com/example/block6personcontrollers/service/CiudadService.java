package com.example.block6personcontrollers.service;


import com.example.block6personcontrollers.model.Ciudad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadService {
    private static List<Ciudad> ciudades = new ArrayList<>();

    public static void agregarCiudad(Ciudad ciudad) {
        ciudades.add(ciudad);
    }

    public static List<Ciudad> obtenerCiudades() {
        return ciudades;
    }
}
