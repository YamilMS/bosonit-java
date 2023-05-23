package com.example.block6personcontrollers.service;

import com.example.block6personcontrollers.model.Persona;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    public Persona createPersona(String nombre, String poblacion, int edad) {
        return new Persona(nombre, poblacion, edad);
    }

    public Persona multiplyAgeByTwo(Persona persona) {
        int newAge = persona.getEdad() * 2;
        persona.setEdad(newAge);
        return persona;
    }
}
