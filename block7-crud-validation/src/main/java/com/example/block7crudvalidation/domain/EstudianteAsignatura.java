package com.example.block7crudvalidation.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estudiante_asignatura")
public class EstudianteAsignatura {
    @Id
    @GeneratedValue
    private String id_asignatura;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    private String asignatura;
    private String coments;
    private Date initial_date;
    private Date finish_date;
}