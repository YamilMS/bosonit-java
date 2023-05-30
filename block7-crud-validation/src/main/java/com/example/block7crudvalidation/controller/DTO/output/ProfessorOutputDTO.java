package com.example.block7crudvalidation.controller.DTO.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorOutputDTO {
    private int id_profesor;
    private PersonaOutputDto persona;
    private String comments;
    private String branch;
    private List<Integer> studentIds;
}

