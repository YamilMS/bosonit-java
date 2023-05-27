package com.example.block7crudvalidation.controller.DTO.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInputDTO {
    private String id_persona;
    private int student_id;
    private int num_hours_week;
    private String coments;
    private String id_profesor;
    private String branch;
}
