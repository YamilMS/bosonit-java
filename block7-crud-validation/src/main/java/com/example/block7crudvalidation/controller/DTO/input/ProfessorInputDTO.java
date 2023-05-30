package com.example.block7crudvalidation.controller.DTO.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorInputDTO {
    private PersonaInputDto persona;
    private String comments;
    private String branch;
    private List<Integer> studentIds;
}
