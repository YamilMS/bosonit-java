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
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue
    private String id_profesor;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    private String coments;
    private String branch;

    @OneToMany(mappedBy = "profesor")
    private List<Student> students;
}
