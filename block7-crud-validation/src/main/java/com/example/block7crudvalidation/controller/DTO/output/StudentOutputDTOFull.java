package com.example.block7crudvalidation.controller.DTO.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentOutputDTOFull extends StudentOutputDTO {
    private PersonaOutputDto persona;
}
