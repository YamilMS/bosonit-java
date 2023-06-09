package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.ProfessorInputDTO;
import com.example.block7crudvalidation.controller.DTO.output.ProfessorOutputDTO;

import java.util.List;

public interface ProfessorService {
    List<ProfessorOutputDTO> findAll();
    ProfessorOutputDTO findById(int id);
    ProfessorOutputDTO save(ProfessorInputDTO professorInputDTO);
    ProfessorOutputDTO update(int id, ProfessorInputDTO professorInputDTO);
    void delete(int id);
}

