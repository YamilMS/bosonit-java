package com.example.block7crudvalidation.controller;

import com.example.block7crudvalidation.application.StudentService;
import com.example.block7crudvalidation.controller.DTO.input.StudentInputDTO;
import com.example.block7crudvalidation.controller.DTO.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentOutputDTO> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentOutputDTO getStudentById(@PathVariable String id) {
        return studentService.findById(id);
    }

    @PostMapping
    public StudentOutputDTO createStudent(@RequestBody StudentInputDTO studentInputDTO) {
        return studentService.save(studentInputDTO);
    }

    @PutMapping("/{id}")
    public StudentOutputDTO updateStudent(@PathVariable String id, @RequestBody StudentInputDTO studentInputDTO) {
        return studentService.update(id, studentInputDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.delete(Integer.parseInt(id));
    }
}
