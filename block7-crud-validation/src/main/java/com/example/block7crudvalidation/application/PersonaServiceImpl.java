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
    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public PersonaOutputDto findById(int id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Persona no encontrada");
                });
        return Mapper.INSTANCE.personaToPersonaOutputDTO(persona);
    }

    @Override
    public PersonaOutputDto findByUsuario(String usuario) throws Exception {
        Persona persona = personaRepository.findByUsuario(usuario)
                .orElseThrow(() -> new Exception("Persona no encontrada"));
        return Mapper.INSTANCE.personaToPersonaOutputDTO(persona);
    }

    @Override
    public List<PersonaOutputDto> findAll() {
        return personaRepository.findAll().stream()
                .map(Mapper.INSTANCE::personaToPersonaOutputDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonaOutputDto save(PersonaInputDto personaInputDTO){
        if (personaInputDTO.getUsuario() == null) {
            throw new UnprocessableEntityException("Usuario no puede ser nulo");
        }
        if (personaInputDTO.getUsuario().length() > 10) {
            throw new UnprocessableEntityException("Longitud de usuario no puede ser superior a 10 caracteres");
        }
        Persona persona = Mapper.INSTANCE.personaInputDTOtoPersona(personaInputDTO);
        Persona savedPersona = personaRepository.save(persona);
        return Mapper.INSTANCE.personaToPersonaOutputDTO(savedPersona);
    }
}
