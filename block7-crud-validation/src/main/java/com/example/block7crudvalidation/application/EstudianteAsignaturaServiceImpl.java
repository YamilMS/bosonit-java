package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.EstudianteAsignaturaInputDTO;
import com.example.block7crudvalidation.controller.DTO.output.EstudianteAsignaturaOutputDTO;
import com.example.block7crudvalidation.domain.EstudianteAsignatura;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.repository.EstudianteAsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteAsignaturaServiceImpl implements EstudianteAsignaturaService{
    @Autowired
    private EstudianteAsignaturaRepository estudianteAsignaturaRepository;
    @Autowired
    private EntityMapper entityMapper;

    public EstudianteAsignaturaServiceImpl(EstudianteAsignaturaRepository estudianteAsignaturaRepository, EntityMapper entityMapper) {
        this.estudianteAsignaturaRepository = estudianteAsignaturaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<EstudianteAsignaturaOutputDTO> findAll() {
        List<EstudianteAsignatura> asignaturas = estudianteAsignaturaRepository.findAll();
        return asignaturas.stream()
                .map(entityMapper::toEstudianteAsignaturaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EstudianteAsignaturaOutputDTO findById(int id) {
        EstudianteAsignatura asignatura = estudianteAsignaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EstudianteAsignatura not found with ID: " + id));
        return entityMapper.toEstudianteAsignaturaDTO(asignatura);
    }

    @Override
    public EstudianteAsignaturaOutputDTO save(EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO) {
        EstudianteAsignatura asignatura = entityMapper.toEstudianteAsignaturaEntity(estudianteAsignaturaInputDTO);
        asignatura = estudianteAsignaturaRepository.save(asignatura);
        return entityMapper.toEstudianteAsignaturaDTO(asignatura);
    }

    @Override
    public EstudianteAsignaturaOutputDTO update(int id, EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO) {
        EstudianteAsignatura asignatura = estudianteAsignaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EstudianteAsignatura not found with ID: " + id));

        // Update asignatura fields based on estudianteAsignaturaInputDTO
        // ...

        asignatura = estudianteAsignaturaRepository.save(asignatura);
        return entityMapper.toEstudianteAsignaturaDTO(asignatura);
    }

    @Override
    public void delete(int id) {
        estudianteAsignaturaRepository.deleteById(id);
    }
}
