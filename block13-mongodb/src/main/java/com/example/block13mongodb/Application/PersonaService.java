package com.example.block13mongodb.Application;

import com.example.block13mongodb.DTO.PersonaInputDTO;
import com.example.block13mongodb.DTO.PersonaOutputDTO;
import com.example.block13mongodb.Domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;


public interface PersonaService {

        Persona savePersona(PersonaInputDTO personaInputDTO);

        List<PersonaOutputDTO> getAllPersonas();

        PersonaOutputDTO getPersonaById(String id);

}
