package com.example.block13mongodb.Controller;

import com.example.block13mongodb.Application.PersonaService;
import com.example.block13mongodb.DTO.PersonaInputDTO;
import com.example.block13mongodb.DTO.PersonaOutputDTO;
import com.example.block13mongodb.Domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public PersonaOutputDTO createPersona(@RequestBody PersonaInputDTO personaInputDTO) {
        Persona persona = personaService.savePersona(personaInputDTO);
        return persona != null ? persona.parsePersonaOutputDTO(persona) : null;
    }

    @GetMapping
    public List<PersonaOutputDTO> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @GetMapping("/{id}")
    public PersonaOutputDTO getPersonaById(@PathVariable String id) {
        return personaService.getPersonaById(id);
    }
    // Implemente más endpoints como PUT y DELETE si los necesita
}