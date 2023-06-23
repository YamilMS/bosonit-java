package com.example.block7crudvalidation;

import com.example.block7crudvalidation.application.EntityMapper;
import com.example.block7crudvalidation.application.PersonaServiceImpl;
import com.example.block7crudvalidation.controller.DTO.output.PersonaOutputDto;
import com.example.block7crudvalidation.domain.Persona;
import com.example.block7crudvalidation.repository.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTestServices {

    @InjectMocks
    private PersonaServiceImpl personaService;

    @Mock
    private PersonaRepository personaRepository;

    @Mock
    private EntityMapper entityMapper;

    @Test
    public void testGetPersonaById() throws Exception {
        Persona persona = new Persona();
        persona.setId_persona(1);

        PersonaOutputDto personaDto = new PersonaOutputDto();
        personaDto.setId_persona(1);

        when(personaRepository.findById(1)).thenReturn(Optional.of(persona));
        when(entityMapper.toPersonaDTO(persona)).thenReturn(personaDto);

        PersonaOutputDto result = personaService.findById(1);

        assertNotNull(result);
        assertEquals(1, result.getId_persona());
    }



    @Test
    public void testGetPersonaByUsername() throws Exception {
        Persona persona = new Persona();
        persona.setUsuario("username");

        PersonaOutputDto personaDto = new PersonaOutputDto();
        personaDto.setUsuario("username");

        when(personaRepository.findByUsuario("username")).thenReturn(Optional.of(persona));
        when(entityMapper.toPersonaDTO(persona)).thenReturn(personaDto);

        PersonaOutputDto result = personaService.findByUsuario("username");

        assertNotNull(result);
        assertEquals("username", result.getUsuario());
    }


}
