package com.example.block7crudvalidation.controller.DTO.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteAsignaturaOutputDTO {
    private int id_asignatura;
    private int studentId;
    private String asignatura;
    private String comments;
    private Date initial_date;
    private Date finish_date;
}

