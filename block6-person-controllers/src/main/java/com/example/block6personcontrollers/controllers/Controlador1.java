package com.example.block6personcontrollers.controllers;

import com.example.block6personcontrollers.model.Persona;
import com.example.block6personcontrollers.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador1")
public class Controlador1 {
    private final PersonaService personaService;

    @Autowired
    public Controlador1(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/addPersona")
    public ResponseEntity<Persona> addPersona(
            @RequestHeader("nombre") String nombre,
            @RequestHeader("poblacion") String poblacion,
            @RequestHeader("edad") int edad
    ) {
        Persona persona = personaService.createPersona(nombre, poblacion, edad);
        return ResponseEntity.ok(persona);
    }
}
