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
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    // Persona
    @Mapping(target = "id_persona", ignore = true)
    Persona toPersonaEntity(PersonaInputDto dto);

    PersonaOutputDto toPersonaDTO(Persona entity);

    // Student
    @Mapping(target = "persona.id_persona", source = "dto.personaId")
    @Mapping(target = "professor.id_profesor", source = "dto.professorId")
    @Mapping(target = "asignaturas", ignore = true)
    Student toStudentEntity(StudentInputDTO dto);
    @Mapping(target = "persona", source = "entity.persona")
    @Mapping(target = "professor", source = "entity.professor")
    @Mapping(target = "asignaturas", ignore = true)
    StudentOutputDTO toStudentDTO(Student entity);
    @Mapping(target = "persona.id_persona", source = "dto.personaId")
    @Mapping(target = "professor.id_profesor", source = "dto.professorId")
    void updateStudentFromDto(@MappingTarget Student entity, StudentInputDTO dto);

    // Professor
    @Mapping(target = "persona", ignore = true)
    Professor toProfessorEntity(ProfessorInputDTO dto);
    @Mapping(target = "persona", source = "entity.persona")
    ProfessorOutputDTO toProfessorDTO(Professor entity);


    // EstudianteAsignatura
    @Mapping(target = "student.student_id", source = "dto.studentId")
    EstudianteAsignatura toEstudianteAsignaturaEntity(EstudianteAsignaturaInputDTO dto);

    @Mapping(target = "studentId", source = "entity.student.student_id")
    EstudianteAsignaturaOutputDTO toEstudianteAsignaturaDTO(EstudianteAsignatura entity);

}
