package com.example.block7crudvalidation.controller;

import com.example.block7crudvalidation.application.ProfessorService;
import com.example.block7crudvalidation.controller.DTO.input.ProfessorInputDTO;
import com.example.block7crudvalidation.controller.DTO.output.ProfessorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<ProfessorOutputDTO> getAllProfessors() {
        return professorService.findAll();
    }

    @GetMapping("/{id}")
    public ProfessorOutputDTO getProfessorById(@PathVariable String id) {
        return professorService.findById(id);
    }

    @PostMapping
    public ProfessorOutputDTO createProfessor(@RequestBody ProfessorInputDTO professorInputDTO) {
        return professorService.save(professorInputDTO);
    }

    @PutMapping("/{id}")
    public ProfessorOutputDTO updateProfessor(@PathVariable String id, @RequestBody ProfessorInputDTO professorInputDTO) {
        return professorService.update(id, professorInputDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable String id) {
        professorService.delete(Integer.parseInt(id));
    }
}

