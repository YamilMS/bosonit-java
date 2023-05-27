package com.example.block7crudvalidation.controller.DTO.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorOutputDTO {
    private int id_profesor;
    private int id_persona;
    private String coments;
    private String branch;
}
