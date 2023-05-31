package com.example.block7crudvalidation.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estudiante_asignatura")
public class EstudianteAsignatura {
    @Id
    @GeneratedValue
    private int id_asignatura;

    @ManyToMany
    @JoinTable(
            name = "student_asignaturas",
            joinColumns = @JoinColumn(name = "id_asignatura"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students= new ArrayList<>();

    private String asignatura;
    private String coments;
    private LocalDate initial_date;
    private LocalDate finish_date;
}