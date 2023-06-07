package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.PersonaInputDto;
import com.example.block7crudvalidation.controller.DTO.output.PersonaOutputDto;

import java.util.List;

public interface PersonaService {

    PersonaOutputDto findById(int id) throws Exception;

    PersonaOutputDto findByUsuario(String usuario) throws Exception;

    List<PersonaOutputDto> findAll();

    PersonaOutputDto save(PersonaInputDto personaInputDTO) throws Exception;

    //PARTE DE CORS
    void addPerson(PersonaInputDto person);

    List<PersonaOutputDto> getAllPersons();
}
