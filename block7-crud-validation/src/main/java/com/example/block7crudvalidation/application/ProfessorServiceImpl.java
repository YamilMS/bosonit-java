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
    private ProfessorRepository professorRepository;

    @Autowired
    private Mapper professorMapper;

    @Override
    public List<ProfessorOutputDTO> findAll() {
        return professorRepository.findAll().stream()
                .map(professorMapper::profesorToOutputDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProfessorOutputDTO findById(String id) {
        Professor professor = professorRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException("No se encontró al profesor con el id: " + id));
        return professorMapper.profesorToOutputDTO(professor);
    }

    @Override
    public ProfessorOutputDTO save(ProfessorInputDTO professorInputDTO) {
        Professor professor = professorMapper.professorToEntity(professorInputDTO);
        return professorMapper.profesorToOutputDTO(professorRepository.save(professor));
    }

    @Override
    public ProfessorOutputDTO update(String id, ProfessorInputDTO professorInputDTO) {
        Professor existingProfessor = professorRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException("No se encontró al profesor con el id: " + id));
        professorMapper.profesorInputDTOtoProfesor(professorInputDTO);
        return professorMapper.profesorToOutputDTO(professorRepository.save(existingProfessor));
    }

    @Override
    public void delete(int id) {
        if (!professorRepository.existsById(id)) {
            throw new EntityNotFoundException("No se encontró al profesor con el id: " + id);
        }
        professorRepository.deleteById(id);
    }
}
