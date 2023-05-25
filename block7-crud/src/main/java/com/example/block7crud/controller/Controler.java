package com.example.block7crud.controller;

import com.example.block7crud.domain.Persona;
import com.example.block7crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controler {

    @Autowired
    private PersonaRepository personaRepository;

    @PostMapping("/addpersona")
    @ResponseBody
    public Persona addPersona(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @GetMapping("/listarpersonas")
    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }
}
