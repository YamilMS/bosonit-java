package com.example.Ejercicio6.controller;

import com.example.Ejercicio6.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControlerUsuario {
    @GetMapping("/user/{nombre}")
    public String getUser(@PathVariable String nombre) {
        return "Hola " + nombre;
    }

    @PostMapping("/useradd")
    public ResponseEntity<Persona> addUser(@RequestBody Persona persona) {
        persona.setEdad(persona.getEdad() + 1);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
}
