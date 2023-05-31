package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.output.ProfessorOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "profesor-service", url = "http://localhost:8081")
public interface Feign {
    @GetMapping("/profesor/{id}")
    ProfessorOutputDTO getProfesor(@PathVariable("id") int id);
}
