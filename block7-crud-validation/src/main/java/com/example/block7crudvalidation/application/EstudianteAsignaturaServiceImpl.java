package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.EstudianteAsignaturaInputDTO;
import com.example.block7crudvalidation.controller.DTO.input.ProfessorInputDTO;
import com.example.block7crudvalidation.controller.DTO.output.EstudianteAsignaturaOutputDTO;
import com.example.block7crudvalidation.controller.DTO.output.ProfessorOutputDTO;
import com.example.block7crudvalidation.domain.EstudianteAsignatura;
import com.example.block7crudvalidation.domain.Professor;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.repository.EstudianteAsignaturaRepository;
import com.example.block7crudvalidation.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteAsignaturaServiceImpl implements EstudianteAsignaturaService{
    @Autowired
    private EstudianteAsignaturaRepository EARepository;

    @Autowired
    private Mapper EAMapper;

    @Override
    public List<EstudianteAsignaturaOutputDTO> findAll() {
        return EARepository.findAll().stream()
                .map(EAMapper::EAtoOutputDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EstudianteAsignaturaOutputDTO findById(String id) {
        EstudianteAsignatura estudianteAsignatura = EARepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException("No se encontró al profesor con el id: " + id));
        return EAMapper.EAtoOutputDTO(estudianteAsignatura);
    }

    @Override
    public EstudianteAsignaturaOutputDTO save(EstudianteAsignaturaInputDTO EAInputDTO) {
        EstudianteAsignatura estudianteEA = EAMapper.EAtoEntity(EAInputDTO);
        return EAMapper.EAtoOutputDTO(EARepository.save(estudianteEA));
    }

    @Override
    public EstudianteAsignaturaOutputDTO update(String id, EstudianteAsignaturaInputDTO EAInputDTO) {
        EstudianteAsignatura existingEA = EARepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException("No se encontró al profesor con el id: " + id));
        EAMapper.EAInputFromDTO(EAInputDTO);
        return EAMapper.EAtoOutputDTO(EARepository.save(existingEA));
    }

    @Override
    public void delete(int id) {
        if (!EARepository.existsById(id)) {
            throw new EntityNotFoundException("No se encontró al profesor con el id: " + id);
        }
        EARepository.deleteById(id);
    }
}
