package com.example.block7crudvalidation.repository;

import com.example.block7crudvalidation.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}