package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.ProfessorInputDTO;
import com.example.block7crudvalidation.controller.DTO.output.ProfessorOutputDTO;
import com.example.block7crudvalidation.domain.Professor;
import com.example.block7crudvalidation.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    private  ProfessorRepository professorRepository;
    @Autowired
    private EntityMapper entityMapper;

    public ProfessorServiceImpl(ProfessorRepository professorRepository, EntityMapper entityMapper) {
        this.professorRepository = professorRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<ProfessorOutputDTO> findAll() {
        List<Professor> professors = professorRepository.findAll();
        return professors.stream()
                .map(entityMapper::toProfessorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProfessorOutputDTO findById(int id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor not found with ID: " + id));
        return entityMapper.toProfessorDTO(professor);
    }

    @Override
    public ProfessorOutputDTO save(ProfessorInputDTO professorInputDTO) {
        Professor professor = entityMapper.toProfessorEntity(professorInputDTO);
        professor = professorRepository.save(professor);
        return entityMapper.toProfessorDTO(professor);
    }

    @Override
    public ProfessorOutputDTO update(int id, ProfessorInputDTO professorInputDTO) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor not found with ID: " + id));

        // Update professor fields based on professorInputDTO
        // ...

        professor = professorRepository.save(professor);
        return entityMapper.toProfessorDTO(professor);
    }

    @Override
    public void delete(int id) {
        professorRepository.deleteById(id);
    }
}
