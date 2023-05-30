package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.EstudianteAsignaturaInputDTO;
import com.example.block7crudvalidation.controller.DTO.input.PersonaInputDto;
import com.example.block7crudvalidation.controller.DTO.input.ProfessorInputDTO;
import com.example.block7crudvalidation.controller.DTO.input.StudentInputDTO;
import com.example.block7crudvalidation.controller.DTO.output.*;
import com.example.block7crudvalidation.domain.EstudianteAsignatura;
import com.example.block7crudvalidation.domain.Persona;
import com.example.block7crudvalidation.domain.Professor;
import com.example.block7crudvalidation.domain.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    // Persona
    @Mapping(target = "id_persona", ignore = true)
    Persona toPersonaEntity(PersonaInputDto dto);

    PersonaOutputDto toPersonaDTO(Persona entity);

    // Student
    @Mapping(target = "persona", source = "dto.persona")
    @Mapping(target = "asignaturas", ignore = true)
    Student toStudentEntity(StudentInputDTO dto);

    @Mapping(target = "persona", source = "entity.persona")
    @Mapping(target = "asignaturas", ignore = true)
    StudentOutputDTO toStudentDTO(Student entity);

    // Professor
    @Mapping(target = "persona", source = "dto.persona")
    @Mapping(target = "students", ignore = true)
    Professor toProfessorEntity(ProfessorInputDTO dto);

    @Mapping(target = "persona", source = "entity.persona")
    @Mapping(target = "studentIds", ignore = true)
    ProfessorOutputDTO toProfessorDTO(Professor entity);

    // EstudianteAsignatura
    @Mapping(target = "student.student_id", source = "dto.studentId")
    EstudianteAsignatura toEstudianteAsignaturaEntity(EstudianteAsignaturaInputDTO dto);

    @Mapping(target = "studentId", source = "entity.student.student_id")
    EstudianteAsignaturaOutputDTO toEstudianteAsignaturaDTO(EstudianteAsignatura entity);

}
