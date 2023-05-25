package com.example.block7crud.domain;

import com.example.block7crud.controller.dto.PersonaInputDto;
import com.example.block7crud.controller.dto.PersonaOutputDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue
    private int id;
    private String nombre, poblacion;
    private int edad;

    public Persona(PersonaInputDto personaInputDto) {
        this.id = personaInputDto.getId();
        this.nombre = personaInputDto.getNombre();
        this.poblacion = personaInputDto.getPoblacion();
        this.edad = personaInputDto.getEdad();
    }

    public PersonaOutputDto personaOutputDto() {
        return new PersonaOutputDto(
                this.id,
                this.nombre,
                this.poblacion,
                this.edad
        );
    }
}
