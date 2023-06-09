package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.EstudianteAsignaturaInputDTO;
import com.example.block7crudvalidation.controller.DTO.output.EstudianteAsignaturaOutputDTO;

import java.util.List;

public interface EstudianteAsignaturaService {
    List<EstudianteAsignaturaOutputDTO> findAll();
    EstudianteAsignaturaOutputDTO findById(int id);
    EstudianteAsignaturaOutputDTO save(EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO);
    EstudianteAsignaturaOutputDTO update(int id, EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO);

    void delete(int id);
}

