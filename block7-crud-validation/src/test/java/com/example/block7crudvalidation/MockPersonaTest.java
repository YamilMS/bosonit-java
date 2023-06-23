package com.example.block7crudvalidation;

import com.example.block7crudvalidation.application.EntityMapper;
import com.example.block7crudvalidation.application.PersonaService;
import com.example.block7crudvalidation.application.PersonaServiceImpl;
import com.example.block7crudvalidation.application.ProfessorService;
import com.example.block7crudvalidation.controller.DTO.input.PersonaInputDto;
import com.example.block7crudvalidation.controller.DTO.input.ProfessorInputDTO;
import com.example.block7crudvalidation.controller.DTO.output.PersonaOutputDto;
import com.example.block7crudvalidation.controller.DTO.output.ProfessorOutputDTO;
import com.example.block7crudvalidation.domain.Persona;
import com.example.block7crudvalidation.domain.Professor;
import com.example.block7crudvalidation.repository.PersonaRepository;
import com.example.block7crudvalidation.repository.ProfessorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MockPersonaTest {

    @MockBean
    private EntityMapper entityMapper;

    @MockBean
    private PersonaRepository personaRepository;

    @MockBean
    private PersonaService personaService;

    @MockBean
    private ProfessorRepository professorRepository;

    @Autowired
    private ProfessorService professorService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        personaService = new PersonaServiceImpl(personaRepository, entityMapper);
    }

    //PERSONA
    @Test
    public void testSetterAndGetter() {
        Persona persona = new Persona();

        String usuario = "testUser";
        String password = "testPassword";
        String name = "testName";
        String surname = "testSurname";
        String companyEmail = "test@company.com";
        String personalEmail = "test@personal.com";
        String city = "testCity";
        boolean active = true;
        Date date = new Date();
        String imageUrl = "testImageUrl";
        Date dateT = new Date();
        int id = 1;

        persona.setUsuario(usuario);
        persona.setPassword(password);
        persona.setName(name);
        persona.setSurname(surname);
        persona.setCompany_email(companyEmail);
        persona.setPersonal_email(personalEmail);
        persona.setCity(city);
        persona.setActive(active);
        persona.setImagen_url(imageUrl);
        persona.setCreated_date(date);
        persona.setTermination_date(dateT);
        persona.setId_persona(id);

        assertEquals(usuario, persona.getUsuario());
        assertEquals(password, persona.getPassword());
        assertEquals(name, persona.getName());
        assertEquals(surname, persona.getSurname());
        assertEquals(companyEmail, persona.getCompany_email());
        assertEquals(personalEmail, persona.getPersonal_email());
        assertEquals(city, persona.getCity());
        assertEquals(active, persona.isActive());
        assertEquals(imageUrl, persona.getImagen_url());
        assertEquals(date, persona.getCreated_date());
        assertEquals(dateT, persona.getTermination_date());
        assertEquals(id, persona.getId_persona());
    }

    //DTO'S
    @Test
    public void testSettersAndGettersInpuTDTO() {
        PersonaInputDto personaInputDto = new PersonaInputDto();
        String usuario = "testUser";
        personaInputDto.setUsuario(usuario);
        assertEquals(usuario, personaInputDto.getUsuario());

        String password = "testPassword";
        personaInputDto.setPassword(password);
        assertEquals(password, personaInputDto.getPassword());

        String name = "testName";
        personaInputDto.setName(name);
        assertEquals(name, personaInputDto.getName());

        String surname = "testSurname";
        personaInputDto.setSurname(surname);
        assertEquals(surname, personaInputDto.getSurname());

        String companyEmail = "test@company.com";
        personaInputDto.setCompany_email(companyEmail);
        assertEquals(companyEmail, personaInputDto.getCompany_email());

        String personalEmail = "test@personal.com";
        personaInputDto.setPersonal_email(personalEmail);
        assertEquals(personalEmail, personaInputDto.getPersonal_email());

        String city = "testCity";
        personaInputDto.setCity(city);
        assertEquals(city, personaInputDto.getCity());

        boolean active = true;
        personaInputDto.setActive(active);
        assertEquals(active, personaInputDto.isActive());

        Date date = new Date();
        personaInputDto.setCreated_date(date);
        assertEquals(date, personaInputDto.getCreated_date());

        String imageUrl = "testImageUrl";
        personaInputDto.setImagen_url(imageUrl);
        assertEquals(imageUrl, personaInputDto.getImagen_url());

        Date terminationDate = new Date();
        personaInputDto.setTermination_date(terminationDate);
        assertEquals(terminationDate, personaInputDto.getTermination_date());
    }

    @Test
    public void testSettersAndGettersOutputDTO() {
        PersonaOutputDto personaOutputDto = new PersonaOutputDto();

        int idPersona = 1;
        personaOutputDto.setId_persona(idPersona);
        assertEquals(idPersona, personaOutputDto.getId_persona());

        String usuario = "testUser";
        personaOutputDto.setUsuario(usuario);
        assertEquals(usuario, personaOutputDto.getUsuario());

        String name = "testName";
        personaOutputDto.setName(name);
        assertEquals(name, personaOutputDto.getName());

        String surname = "testSurname";
        personaOutputDto.setSurname(surname);
        assertEquals(surname, personaOutputDto.getSurname());

        String companyEmail = "test@company.com";
        personaOutputDto.setCompany_email(companyEmail);
        assertEquals(companyEmail, personaOutputDto.getCompany_email());

        String personalEmail = "test@personal.com";
        personaOutputDto.setPersonal_email(personalEmail);
        assertEquals(personalEmail, personaOutputDto.getPersonal_email());

        String city = "testCity";
        personaOutputDto.setCity(city);
        assertEquals(city, personaOutputDto.getCity());

        boolean active = true;
        personaOutputDto.setActive(active);
        assertEquals(active, personaOutputDto.isActive());

        Date date = new Date();
        personaOutputDto.setCreated_date(date);
        assertEquals(date, personaOutputDto.getCreated_date());

        String imageUrl = "testImageUrl";
        personaOutputDto.setImagen_url(imageUrl);
        assertEquals(imageUrl, personaOutputDto.getImagen_url());

        Date terminationDate = new Date();
        personaOutputDto.setTermination_date(terminationDate);
        assertEquals(terminationDate, personaOutputDto.getTermination_date());
    }

    //REPOSITORIO

    //SERVICIO
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
    public void findByUsuarioTest() throws Exception {
        Persona persona = new Persona();
        persona.setUsuario("test_user");

        PersonaOutputDto outputDto = new PersonaOutputDto();
        outputDto.setUsuario("TestUser");

        // Configurar el comportamiento del método findByUsuario del repositorio para que devuelva la persona
        when(personaRepository.findByUsuario("TestUser")).thenReturn(Optional.of(persona));

        // Configurar el comportamiento del método toPersonaDTO
        when(entityMapper.toPersonaDTO(persona)).thenReturn(outputDto);

        // Llamar al método que estamos probando y guardar el resultado
        PersonaOutputDto result = personaService.findByUsuario("TestUser");

        // Comprobar que el resultado es el que esperábamos
        assertEquals(outputDto.getUsuario(), result.getUsuario());
        // ... hacer más comprobaciones según sea necesario
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



    @Test
    public void saveTest() throws Exception {
        PersonaInputDto inputDto = new PersonaInputDto();
        inputDto.setUsuario("test_user");

        Persona persona = new Persona();
        persona.setUsuario(inputDto.getUsuario());

        PersonaOutputDto outputDto = new PersonaOutputDto();
        outputDto.setUsuario("TestUser");

        when(entityMapper.toPersonaEntity(inputDto)).thenReturn(persona);
        when(entityMapper.toPersonaDTO(persona)).thenReturn(outputDto);

        when(personaRepository.save(any(Persona.class))).thenReturn(persona);

        PersonaOutputDto result = personaService.save(inputDto);

       assertEquals(outputDto.getUsuario(), result.getUsuario());
    }



}
