package com.example.block7crudvalidation.controller.DTO.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentOutputDTO {
    private int student_id;;
    private String id_persona;
    private int num_hours_week;
    private String coments;
    private String id_profesor;
    private String branch;
}
