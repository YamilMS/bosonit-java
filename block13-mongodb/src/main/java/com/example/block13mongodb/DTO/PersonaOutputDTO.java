package com.example.block13mongodb.DTO;

import com.example.block13mongodb.Domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaOutputDTO {
    String id;
    String usuario;
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

    public PersonaOutputDTO(Persona persona) {
        this.id = persona.getId();
        this.usuario = persona.getUsuario();
        this.name = persona.getName();
        this.surname = persona.getSurname();
        this.company_email = persona.getCompany_email();
        this.personal_email = persona.getPersonal_email();
        this.city = persona.getCity();
        this.active = persona.getActive();
        this.created_date = persona.getCreated_date();
        this.imagen_url = persona.getImagen_url();
        this.termination_date = persona.getTermination_date();
    }
}
