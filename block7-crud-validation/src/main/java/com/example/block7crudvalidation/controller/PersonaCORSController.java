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
public class PersonaCORSController {

    private final PersonaService personaService;

    @Autowired
    public PersonaCORSController(PersonaService personaService) {
        this.personaService = personaService;
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