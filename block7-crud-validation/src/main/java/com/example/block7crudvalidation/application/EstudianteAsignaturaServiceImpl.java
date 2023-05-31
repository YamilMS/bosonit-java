package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.EstudianteAsignaturaInputDTO;
import com.example.block7crudvalidation.controller.DTO.output.EstudianteAsignaturaOutputDTO;
import com.example.block7crudvalidation.domain.EstudianteAsignatura;
import com.example.block7crudvalidation.domain.Persona;
import com.example.block7crudvalidation.domain.Student;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.repository.EstudianteAsignaturaRepository;
import com.example.block7crudvalidation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteAsignaturaServiceImpl implements EstudianteAsignaturaService{
    @Autowired
    private EstudianteAsignaturaRepository estudianteAsignaturaRepository;
    @Autowired
    private StudentRepository studentRepository;
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
        Student student = studentRepository.findById(estudianteAsignaturaInputDTO.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + estudianteAsignaturaInputDTO.getStudentId()));

        EstudianteAsignatura estudianteAsignatura = entityMapper.toEstudianteAsignaturaEntity(estudianteAsignaturaInputDTO);

        estudianteAsignatura.getStudents().add(student);
        estudianteAsignatura.setInitial_date(LocalDate.from(LocalDateTime.now()));
        student.getAsignaturas().add(estudianteAsignatura);
        estudianteAsignatura.setFinish_date(LocalDate.from((LocalDateTime.now().plusMonths(6))));
        estudianteAsignatura = estudianteAsignaturaRepository.save(estudianteAsignatura);

        return entityMapper.toEstudianteAsignaturaDTO(estudianteAsignatura);
    }


    @Override
    public EstudianteAsignaturaOutputDTO update(int id, EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO) {

        EstudianteAsignatura estudianteAsignatura = estudianteAsignaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EstudianteAsignatura not found with ID: " + id));

        Student student = studentRepository.findById(estudianteAsignaturaInputDTO.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + estudianteAsignaturaInputDTO.getStudentId()));

        if (!estudianteAsignatura.getStudents().contains(student)) {
            estudianteAsignatura.getStudents().add(student);
            student.getAsignaturas().add(estudianteAsignatura);
        }

        entityMapper.updateEstudianteAsignaturaFromDto(estudianteAsignatura, estudianteAsignaturaInputDTO);

        estudianteAsignatura = estudianteAsignaturaRepository.save(estudianteAsignatura);

        return entityMapper.toEstudianteAsignaturaDTO(estudianteAsignatura);
    }

    @Override
    public void delete(int id) {
        estudianteAsignaturaRepository.deleteById(id);
    }
}
