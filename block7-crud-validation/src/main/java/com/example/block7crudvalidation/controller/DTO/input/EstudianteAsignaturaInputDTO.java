package com.example.block7crudvalidation.controller.DTO.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteAsignaturaInputDTO {
    private int id_asignatura;
    private int id_student;
    private String asignatura;
    private String coments;
    private Date initial_date;
    private Date finish_date;
}
