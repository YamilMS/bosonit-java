package com.example.block7crudvalidation.controller.DTO.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorInputDTO {
    private int personaId;
    private String coments;
    private String branch;
}
