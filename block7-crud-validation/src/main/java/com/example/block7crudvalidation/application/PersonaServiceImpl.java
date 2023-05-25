package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.PersonaInputDto;
import com.example.block7crudvalidation.controller.DTO.output.PersonaOutputDto;
import com.example.block7crudvalidation.domain.Persona;
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
    public PersonaOutputDto findById(int id) throws Exception {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new Exception("Persona no encontrada"));
        return PersonaMapper.INSTANCE.personaToPersonaOutputDTO(persona);
    }

    @Override
    public PersonaOutputDto findByUsuario(String usuario) throws Exception {
        Persona persona = personaRepository.findByUsuario(usuario)
                .orElseThrow(() -> new Exception("Persona no encontrada"));
        return PersonaMapper.INSTANCE.personaToPersonaOutputDTO(persona);
    }

    @Override
    public List<PersonaOutputDto> findAll() {
        return personaRepository.findAll().stream()
                .map(PersonaMapper.INSTANCE::personaToPersonaOutputDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonaOutputDto save(PersonaInputDto personaInputDTO) throws Exception {
        if (personaInputDTO.getUsuario() == null) {
            throw new Exception("Usuario no puede ser nulo");
        }
        if (personaInputDTO.getUsuario().length() > 10) {
            throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres");
        }
        Persona persona = PersonaMapper.INSTANCE.personaInputDTOtoPersona(personaInputDTO);
        Persona savedPersona = personaRepository.save(persona);
        return PersonaMapper.INSTANCE.personaToPersonaOutputDTO(savedPersona);
    }
}
