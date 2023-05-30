package com.example.block7crudvalidation.controller;

import com.example.block7crudvalidation.application.EstudianteAsignaturaService;
import com.example.block7crudvalidation.controller.DTO.input.EstudianteAsignaturaInputDTO;
import com.example.block7crudvalidation.controller.DTO.output.EstudianteAsignaturaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudianteAsignatura")
public class EstudianteAsignaturaController {

    @Autowired
    private EstudianteAsignaturaService estudianteAsignaturaService;

    @GetMapping
    public List<EstudianteAsignaturaOutputDTO> getAllEstudianteAsignatura() {
        return estudianteAsignaturaService.findAll();
    }

    @GetMapping("/{id}")
    public EstudianteAsignaturaOutputDTO getEstudianteAsignaturaById(@PathVariable int id) {
        return estudianteAsignaturaService.findById(id);
    }

    @PostMapping
    public EstudianteAsignaturaOutputDTO createEstudianteAsignatura(@RequestBody EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO) {
        return estudianteAsignaturaService.save(estudianteAsignaturaInputDTO);
    }

    @PutMapping("/{id}")
    public EstudianteAsignaturaOutputDTO updateEstudianteAsignatura(@PathVariable int id, @RequestBody EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO) {
        return estudianteAsignaturaService.update(id, estudianteAsignaturaInputDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEstudianteAsignatura(@PathVariable String id) {
        estudianteAsignaturaService.delete(Integer.parseInt(id));
    }
}

