package com.example.block7crudvalidation;

import com.example.block7crudvalidation.application.EntityMapper;
import com.example.block7crudvalidation.application.PersonaService;
import com.example.block7crudvalidation.controller.DTO.input.PersonaInputDto;
import com.example.block7crudvalidation.controller.DTO.output.PersonaOutputDto;
import com.example.block7crudvalidation.controller.PersonaController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonaControllerTest {

    @Autowired
    private PersonaController personaController;

    @Autowired
    private EntityMapper entityMapper;

    @MockBean
    private PersonaService personaService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(personaController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testGetPersonaById() throws Exception {
        int id = 1;
        mockMvc.perform(get("/personas/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetPersonaByUsername() throws Exception {
        String usuario = "usuarioTest";
        mockMvc.perform(get("/personas/usuario/" + usuario)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllPersonas() throws Exception {
        mockMvc.perform(get("/personas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreatePersona() throws Exception {
        // Use a PersonaInputDto to create a new person
        PersonaInputDto personaInputDto = new PersonaInputDto(/* Fill the required data */);
        String personaJson = new ObjectMapper().writeValueAsString(personaInputDto);

        mockMvc.perform(post("/personas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(personaJson))
                .andExpect(status().isOk());
    }

    @Test
    public void addPersonTest() throws Exception {
        // Given
        PersonaInputDto personaInputDto = new PersonaInputDto("user1", "pass1", "name1", "surname1", "company_email1", "personal_email1", "city1", true, new Date(), "image_url1", new Date());

        // When
        MvcResult mvcResult = mockMvc.perform(post("/personas/addperson")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personaInputDto)))
                .andExpect(status().isOk())
                .andReturn();

        // Then
        String response = mvcResult.getResponse().getContentAsString();
        assertEquals("Persona con CORS CREADA", response);
    }

    @Test
    public void getAllPersonsTest() throws Exception {
        // Given
        PersonaOutputDto personaDto1 = new PersonaOutputDto(1, "usuario1", "name1", "surname1", "company_email1", "personal_email1", "city1", true, new Date(), "imagen_url1", null);
        PersonaOutputDto personaDto2 = new PersonaOutputDto(2, "usuario2", "name2", "surname2", "company_email2", "personal_email2", "city2", true, new Date(), "imagen_url2", null);
        List<PersonaOutputDto> personas = Arrays.asList(personaDto1, personaDto2);

        when(personaService.getAllPersons()).thenReturn(personas);

        // When
        MvcResult mvcResult = mockMvc.perform(get("/personas/getall")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Convert response to list of PersonaOutputDto
        String contentAsString = mvcResult.getResponse().getContentAsString();
        List<PersonaOutputDto> returnedPersonas = objectMapper.readValue(contentAsString, new TypeReference<List<PersonaOutputDto>>() {});

        // Then
        assertThat(returnedPersonas)
                .hasSize(2)
                .containsExactlyInAnyOrder(personaDto1, personaDto2);

        verify(personaService, times(1)).getAllPersons();
    }


}
