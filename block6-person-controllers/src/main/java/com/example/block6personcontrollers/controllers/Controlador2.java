package com.example.block6personcontrollers.controllers;

import com.example.block6personcontrollers.model.Persona;
import com.example.block6personcontrollers.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/controlador2")
public class Controlador2 {
    private final PersonaService servicioPersona;
    private final Controlador1 controlador1;

    @Autowired
    public Controlador2(PersonaService servicioPersona, Controlador1 controlador1) {
        this.servicioPersona = servicioPersona;
        this.controlador1 = controlador1;
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
}
