package com.example.block7crudvalidation.controller.DTO.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInputDTO {
    private int personaId;
    private int num_hours_week;
    private String coments;
    private int professorId;
    private String branch;
    private List<Integer> asignaturasId;
}

