package com.example.block7crudvalidation.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    private int student_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    private int num_hours_week;
    private String coments;

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    private String branch;

    @OneToMany(mappedBy = "student")
    private List<EstudianteAsignatura> asignaturas;
}