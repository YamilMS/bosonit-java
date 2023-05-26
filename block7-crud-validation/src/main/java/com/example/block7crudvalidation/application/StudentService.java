package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.StudentInputDTO;
import com.example.block7crudvalidation.controller.DTO.output.StudentOutputDTO;

import java.util.List;

public interface StudentService {
    List<StudentOutputDTO> findAll();
    StudentOutputDTO findById(String id);
    StudentOutputDTO save(StudentInputDTO studentInputDTO);
    StudentOutputDTO update(String id, StudentInputDTO studentInputDTO);
    void delete(int id);
}
