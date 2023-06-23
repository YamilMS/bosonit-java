package com.example.block7crudvalidation;

import com.example.block7crudvalidation.application.EntityMapper;
import com.example.block7crudvalidation.application.ProfessorService;
import com.example.block7crudvalidation.controller.DTO.input.ProfessorInputDTO;
import com.example.block7crudvalidation.controller.DTO.output.ProfessorOutputDTO;
import com.example.block7crudvalidation.domain.Persona;
import com.example.block7crudvalidation.domain.Professor;
import com.example.block7crudvalidation.repository.PersonaRepository;
import com.example.block7crudvalidation.repository.ProfessorRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MockProfessorTest {

    @MockBean
    private EntityMapper entityMapper;

    @MockBean
    private ProfessorRepository professorRepository;
    @MockBean
    private PersonaRepository personaRepository;
    @Autowired
    private ProfessorService professorService;

    @Test
    public void findAllTest() {
        // Preparar datos de prueba
        List<Professor> professors = new ArrayList<>();
        professors.add(new Professor());
        professors.add(new Professor());

        when(professorRepository.findAll()).thenReturn(professors);
        when(entityMapper.toProfessorDTO(any(Professor.class))).thenReturn(new ProfessorOutputDTO());

        // Llamar al método a probar
        List<ProfessorOutputDTO> result = professorService.findAll();

        // Verificar el tamaño de la lista result
        assertEquals(2, result.size());
    }

    @Test
    public void findByIdTest() {
        // Preparar datos de prueba
        int professorId = 1;
        Professor professor = new Professor();

        when(professorRepository.findById(professorId)).thenReturn(Optional.of(professor));
        when(entityMapper.toProfessorDTO(any(Professor.class))).thenReturn(new ProfessorOutputDTO());

        // Llamar al método a probar
        ProfessorOutputDTO result = professorService.findById(professorId);

        // Verificar el resultado
        assertNotNull(result);
    }

    @Test
    public void updateTest() {
        int professorId = 1;
        int personaId = 2;
        ProfessorInputDTO professorInputDTO = new ProfessorInputDTO();
        professorInputDTO.setPersonaId(personaId);

        Professor professor = new Professor();
        Persona persona = new Persona();
        Professor savedProfessor = new Professor();

        when(professorRepository.findById(professorId)).thenReturn(Optional.of(professor));
        when(personaRepository.findById(personaId)).thenReturn(Optional.of(persona));
        when(professorRepository.save(professor)).thenReturn(savedProfessor);
        when(entityMapper.toProfessorDTO(savedProfessor)).thenReturn(new ProfessorOutputDTO());

        // Llamar al método a probar
        ProfessorOutputDTO result = professorService.update(professorId, professorInputDTO);

        // Verificar el resultado
        assertNotNull(result);
    }


}
