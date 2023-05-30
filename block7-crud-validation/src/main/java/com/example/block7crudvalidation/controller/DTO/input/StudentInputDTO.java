package com.example.block7crudvalidation.controller.DTO.input;

import com.example.block7crudvalidation.domain.Persona;
import com.example.block7crudvalidation.domain.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInputDTO {
    private PersonaInputDto persona;
    private int num_hours_week;
    private String comments;
    private int professorId;
    private String branch;
    private List<EstudianteAsignaturaInputDTO> asignaturas;
}

