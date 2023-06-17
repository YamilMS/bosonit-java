package com.example.block13mongodb.DTO;

import com.example.block13mongodb.Domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PersonaInputDTO {
    String id;
    String usuario;
    String password;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    Boolean admin;
    Date created_date;
    String imagen_url;
    Date termination_date;

    public Persona parsePersona(PersonaInputDTO persona) {
        return new Persona(persona);
    }
}
