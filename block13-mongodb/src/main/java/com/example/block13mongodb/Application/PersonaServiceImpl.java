package com.example.block13mongodb.Application;

import com.example.block13mongodb.DTO.PersonaInputDTO;
import com.example.block13mongodb.DTO.PersonaOutputDTO;
import com.example.block13mongodb.Domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Persona savePersona(PersonaInputDTO personaInputDTO) {
        Persona persona = new Persona(personaInputDTO);
        return mongoTemplate.save(persona);
    }

    public List<PersonaOutputDTO> getAllPersonas() {
        List<Persona> personas = mongoTemplate.findAll(Persona.class);
        return Persona.parsePersonaOutputDTO(personas);
    }

    public PersonaOutputDTO getPersonaById(String id) {
        Persona persona = mongoTemplate.findById(id, Persona.class);
        if(persona != null) {
            return persona.parsePersonaOutputDTO(persona);
        }
        return null;
    }

    // Implemente más métodos como update y delete si los necesita
}
