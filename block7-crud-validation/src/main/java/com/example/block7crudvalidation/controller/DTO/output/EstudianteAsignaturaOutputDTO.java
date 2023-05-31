package com.example.block7crudvalidation.controller.DTO.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteAsignaturaOutputDTO {
    private int studentId;
    private StudentOutputDTO student;
    private String asignatura;
    private String coments;
    private LocalDate initial_date;
    private LocalDate finish_date;
}

