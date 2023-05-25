package com.example.block7crud.application;

import com.example.block7crud.controller.dto.PersonaInputDto;
import com.example.block7crud.controller.dto.PersonaOutputDto;

public interface PersonaService {
    PersonaOutputDto addPersona(PersonaInputDto persona);
    PersonaOutputDto getPersonaById(int id);
    void deletePersonaById( int id);
    Iterable<PersonaOutputDto> getAllPersona(int pageNumber, int pageSize);
    PersonaOutputDto updatePersona(PersonaInputDto persona);

}
