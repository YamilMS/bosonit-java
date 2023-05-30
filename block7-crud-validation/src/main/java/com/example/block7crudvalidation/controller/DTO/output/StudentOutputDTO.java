package com.example.block7crudvalidation.controller.DTO.output;

import com.example.block7crudvalidation.domain.Persona;
import com.example.block7crudvalidation.domain.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentOutputDTO {
    private int student_id;
    private PersonaOutputDto persona;
    private int num_hours_week;
    private String coments;
    private ProfessorOutputDTO professor;
    private String branch;
    private List<EstudianteAsignaturaOutputDTO> asignaturas;
}
