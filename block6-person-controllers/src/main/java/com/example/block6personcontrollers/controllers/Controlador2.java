package com.example.block6personcontrollers.controllers;

import com.example.block6personcontrollers.model.Ciudad;
import com.example.block6personcontrollers.model.Persona;
import com.example.block6personcontrollers.service.CiudadService;
import com.example.block6personcontrollers.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/controlador2")
public class Controlador2 {
    private final PersonaService servicioPersona;
    private final CiudadService ciudadService;
    private final Controlador1 controlador1;

    @Autowired
    public Controlador2(PersonaService servicioPersona, Controlador1 controlador1, CiudadService ciudadService) {
        this.servicioPersona = servicioPersona;
        this.controlador1 = controlador1;
        this.ciudadService = ciudadService;
    }

    @GetMapping("/getPersona")
    public ResponseEntity<Persona> getPersona() {
        Persona persona = controlador1.addPersona("John Doe", "Ciudad XYZ", 30).getBody();

        if (persona == null) {
            return ResponseEntity.notFound().build();
        }

        persona = servicioPersona.multiplyAgeByTwo(persona);
        return ResponseEntity.ok(persona);
    }

    @GetMapping("/getCiudades")
    public List<Ciudad> getCiudades() {
        return CiudadService.obtenerCiudades();
    }
}
