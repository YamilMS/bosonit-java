package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.PersonaInputDto;
import com.example.block7crudvalidation.controller.DTO.output.PersonaOutputDto;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PersonaService {

    PersonaOutputDto findById(int id) throws Exception;

    PersonaOutputDto findByUsuario(String usuario) throws Exception;

    List<PersonaOutputDto> findAll();

    PersonaOutputDto save(PersonaInputDto personaInputDTO) throws Exception;

    //PARTE DE CORS
    void addPerson(PersonaInputDto person);

    List<PersonaOutputDto> getAllPersons();

    //PARTE CRITERIABUILDER
    List<PersonaOutputDto> searchByCriteria(String usuario, String name, String surname, Date fechaInicio, Date fechaFin, String sortField, Pageable pageable) throws Exception;


}
