package com.example.block7crudvalidation.controller.DTO.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteAsignaturaInputDTO {
    private int studentId;
    private String asignatura;
    private String coments;
    private LocalDate initial_date;
    private LocalDate finish_date;
}

