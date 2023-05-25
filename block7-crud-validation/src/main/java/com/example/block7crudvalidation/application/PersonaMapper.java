package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.PersonaInputDto;
import com.example.block7crudvalidation.controller.DTO.output.PersonaOutputDto;
import com.example.block7crudvalidation.domain.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonaMapper {

    PersonaMapper INSTANCE = Mappers.getMapper( PersonaMapper.class );

    @Mapping(target = "id_persona", source = "id_persona")
    PersonaOutputDto personaToPersonaOutputDTO(Persona persona);
    @Mapping(target = "id_persona", source = "id_persona")
    Persona personaInputDTOtoPersona(PersonaInputDto personaInputDTO);
}
