package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.PersonaInputDto;
import com.example.block7crudvalidation.controller.DTO.input.StudentInputDTO;
import com.example.block7crudvalidation.controller.DTO.output.StudentOutputDTO;
import com.example.block7crudvalidation.controller.DTO.output.StudentOutputDTOFull;
import com.example.block7crudvalidation.domain.Persona;
import com.example.block7crudvalidation.domain.Student;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.repository.PersonaRepository;
import com.example.block7crudvalidation.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private final EntityMapper entityMapper;

    public StudentServiceImpl(StudentRepository studentRepository, EntityMapper entityMapper) {
        this.studentRepository = studentRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<StudentOutputDTO> findAll() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(entityMapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentOutputDTO findById(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
        return entityMapper.toStudentDTO(student);
    }

    @Override
    public StudentOutputDTO save(StudentInputDTO studentInputDTO) {

        Persona persona = entityMapper.toPersonaEntity(studentInputDTO.getPersona());

        Optional<Persona> existingPersona = personaRepository.findByUsuario(persona.getUsuario());
        if(existingPersona.isPresent()) {
            persona = existingPersona.get();
        } else {
            persona = personaRepository.save(persona);
        }

        Student student = entityMapper.toStudentEntity(studentInputDTO);
        student.setPersona(persona);
        student = studentRepository.save(student);

        return entityMapper.toStudentDTO(student);
    }
    @Override
    public StudentOutputDTO update(int id, StudentInputDTO studentInputDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));

        entityMapper.updateStudentFromDto(student, studentInputDTO);

        Persona existingPersona = student.getPersona();
        Optional<Persona> matchingPersona = personaRepository.findByUsuario(existingPersona.getUsuario());
        if (matchingPersona.isPresent()) {
            Persona updatedPersona = matchingPersona.get();
            entityMapper.updatePersonaFromDto(updatedPersona, studentInputDTO.getPersona());
            existingPersona = personaRepository.save(updatedPersona);
        } else {
            existingPersona = personaRepository.save(existingPersona);
        }

        student.setPersona(existingPersona);

        student = studentRepository.save(student);

        return entityMapper.toStudentDTO(student);
    }

    @Override
    public void delete(int id) {
        studentRepository.deleteById(id);
    }
}

