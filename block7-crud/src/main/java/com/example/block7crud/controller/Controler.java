package com.example.block7crud.controller;

import com.example.block7crud.domain.Persona;
import com.example.block7crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controler {

    @Autowired
    private PersonaRepository personaRepository;

    @PostMapping("/persona")
    @ResponseBody
    public Persona addPersona(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @GetMapping("/persona")
    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    @GetMapping("/persona/{id}")
    @ResponseBody
    public ResponseEntity<Object> getPersonaById(@PathVariable Integer id) {
        Optional<Persona> personaOptional = personaRepository.findById(id);

        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
            return ResponseEntity.ok(persona);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("persona/nombre/{nombre}")
    @ResponseBody
    public List<Persona> listPersonasNombre(@PathVariable String nombre) {
        List<Persona> personaBuscada = new ArrayList<Persona>();
        for (Persona persona: personaRepository.findAll()) {
            if (persona.getNombre().equals(nombre)) {
                personaBuscada.add(persona);
            }
        }
        return personaBuscada;
    }

    @PutMapping("/persona/{id}")
    @ResponseBody
    public ResponseEntity<Object> updatePersona(@PathVariable Integer id, @RequestBody Persona personaInput) {
        Optional<Persona> personaOptional = personaRepository.findById(id);

        if (personaOptional.isPresent()) {
            if (personaInput.getNombre() != null && personaInput.getPoblacion() != null && personaInput.getEdad() >= 0) {
                Persona persona = personaOptional.get();
                persona.setNombre(personaInput.getNombre());
                persona.setEdad(personaInput.getEdad());
                persona.setPoblacion(personaInput.getPoblacion());
                return ResponseEntity.ok(personaRepository.save(persona));
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/persona/{id}")
    @ResponseBody
    public ResponseEntity<Object> deletePersona(@PathVariable Integer id) {
        Optional<Persona> personaOptional = personaRepository.findById(id);

        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
            personaRepository.delete(persona);
            return ResponseEntity.ok(persona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
