package com.example.block7crudvalidation.controller;

import com.example.block7crudvalidation.application.PersonaService;
import com.example.block7crudvalidation.controller.DTO.input.PersonaInputDto;
import com.example.block7crudvalidation.controller.DTO.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/{id}")
    public PersonaOutputDto getPersonaById(@PathVariable int id) throws Exception {
        return personaService.findById(id);
    }

    @GetMapping("/usuario/{usuario}")
    public PersonaOutputDto getPersonaByUsername(@PathVariable String usuario) throws Exception {
        return personaService.findByUsuario(usuario);
    }

    @GetMapping
    public List<PersonaOutputDto> getAllPersonas() {
        return personaService.findAll();
    }

    @PostMapping
    public PersonaOutputDto createPersona(@RequestBody PersonaInputDto personaInputDto) throws Exception {
        return personaService.save(personaInputDto);
    }

    //PARTE DE CORS
    @PostMapping("/addperson")
    public ResponseEntity<String> addPerson(@RequestBody PersonaInputDto personaInputDto) {
        personaService.addPerson(personaInputDto);
        return new ResponseEntity<>("Persona con CORS CREADA", HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<PersonaOutputDto>> getAllPersons() {
        List<PersonaOutputDto> persons = personaService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
