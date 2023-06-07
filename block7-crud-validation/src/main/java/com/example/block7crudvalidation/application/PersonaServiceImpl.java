package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.PersonaInputDto;
import com.example.block7crudvalidation.controller.DTO.output.PersonaOutputDto;
import com.example.block7crudvalidation.domain.Persona;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.exceptions.UnprocessableEntityException;
import com.example.block7crudvalidation.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private EntityMapper entityMapper;

    public PersonaServiceImpl(PersonaRepository personaRepository, EntityMapper entityMapper) {
        this.personaRepository = personaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public PersonaOutputDto findById(int id) throws Exception {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new Exception("Persona not found with ID: " + id));
        return entityMapper.toPersonaDTO(persona);
    }

    @Override
    public PersonaOutputDto findByUsuario(String usuario) throws Exception {
        Persona persona = personaRepository.findByUsuario(usuario)
                .orElseThrow(() -> new Exception("Persona not found with usuario: " + usuario));
        return entityMapper.toPersonaDTO(persona);
    }

    @Override
    public List<PersonaOutputDto> findAll() {
        List<Persona> personas = personaRepository.findAll();
        return personas.stream()
                .map(entityMapper::toPersonaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonaOutputDto save(PersonaInputDto personaInputDTO) throws Exception {
        Persona persona = entityMapper.toPersonaEntity(personaInputDTO);
        persona = personaRepository.save(persona);
        return entityMapper.toPersonaDTO(persona);
    }

    //PARTE DE CORS
    @Override
    public void addPerson(PersonaInputDto personaInputDto) {
        Persona person = entityMapper.toPersonaEntity(personaInputDto);
        personaRepository.save(person);
    }

    @Override
    public List<PersonaOutputDto> getAllPersons() {
        List<Persona> personas = personaRepository.findAll();
        return personas.stream()
                .map(entityMapper::toPersonaDTO)
                .collect(Collectors.toList());
    }
}
