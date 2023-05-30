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
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue
    private int id_persona;

    @Column(nullable = false, length = 10)
    private String usuario;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column
    private String surname;

    @Column(nullable = false)
    private String company_email;

    @Column(nullable = false)
    private String personal_email;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private Date created_date;

    @Column
    private String imagen_url;

    @Column
    private Date termination_date;

}
