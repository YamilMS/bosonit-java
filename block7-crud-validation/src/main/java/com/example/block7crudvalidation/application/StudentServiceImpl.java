package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.StudentInputDTO;
import com.example.block7crudvalidation.controller.DTO.output.StudentOutputDTO;
import com.example.block7crudvalidation.domain.Student;
import com.example.block7crudvalidation.exceptions.EntityNotFoundException;
import com.example.block7crudvalidation.repository.StudentRepository;
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
    private Mapper studentMapper;

    @Override
    public List<StudentOutputDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(studentMapper::StudentToOutputDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentOutputDTO findById(String id) {
        Student student = studentRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        return studentMapper.StudentToOutputDTO(student);
    }

    @Override
    public StudentOutputDTO save(StudentInputDTO studentInputDTO) {
        Student student = studentMapper.studentToEntity(studentInputDTO);
        student = studentRepository.save(student);
        return studentMapper.StudentToOutputDTO(student);
    }

    @Override
    public StudentOutputDTO update(String id, StudentInputDTO studentInputDTO) {
        Student student = studentRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        studentMapper.studentInputDTOtoStudent(studentInputDTO);
        student = studentRepository.save(student);
        return studentMapper.StudentToOutputDTO(student);
    }

    @Override
    public void delete(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Student not found");
        }
    }
}

