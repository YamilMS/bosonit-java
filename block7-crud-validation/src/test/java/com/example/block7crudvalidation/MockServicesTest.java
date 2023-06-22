package com.example.block7crudvalidation;

import com.example.block7crudvalidation.application.EntityMapper;
import com.example.block7crudvalidation.application.PersonaService;
import com.example.block7crudvalidation.application.PersonaServiceImpl;
import com.example.block7crudvalidation.controller.DTO.output.PersonaOutputDto;
import com.example.block7crudvalidation.domain.Persona;
import com.example.block7crudvalidation.repository.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MockServicesTest {

    @MockBean
    private PersonaRepository personaRepository;

    @Mock
    private EntityMapper entityMapper;

    private PersonaService personaService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        personaService = new PersonaServiceImpl(personaRepository, entityMapper);
    }

    @Test
    public void testFindById() throws Exception {
        Persona persona = new Persona();
        persona.setId_persona(1);

        PersonaOutputDto personaOutputDto = new PersonaOutputDto();
        personaOutputDto.setId_persona(1);

        when(personaRepository.findById(1)).thenReturn(Optional.of(persona));
        when(entityMapper.toPersonaDTO(persona)).thenReturn(personaOutputDto);

        PersonaOutputDto foundPersona = personaService.findById(1);

        assertEquals(1, foundPersona.getId_persona());
    }

    @Test
    public void testFindAll() {
        Persona persona1 = new Persona();
        persona1.setId_persona(1);

        Persona persona2 = new Persona();
        persona2.setId_persona(2);

        PersonaOutputDto personaOutputDto1 = new PersonaOutputDto();
        personaOutputDto1.setId_persona(1);

        PersonaOutputDto personaOutputDto2 = new PersonaOutputDto();
        personaOutputDto2.setId_persona(2);

        when(personaRepository.findAll()).thenReturn(Arrays.asList(persona1, persona2));
        when(entityMapper.toPersonaDTO(persona1)).thenReturn(personaOutputDto1);
        when(entityMapper.toPersonaDTO(persona2)).thenReturn(personaOutputDto2);

        List<PersonaOutputDto> personas = personaService.findAll();

        assertEquals(2, personas.size());
    }
}
