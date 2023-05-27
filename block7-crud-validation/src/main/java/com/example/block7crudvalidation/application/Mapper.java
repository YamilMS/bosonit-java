package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.EstudianteAsignaturaInputDTO;
import com.example.block7crudvalidation.controller.DTO.input.PersonaInputDto;
import com.example.block7crudvalidation.controller.DTO.input.ProfessorInputDTO;
import com.example.block7crudvalidation.controller.DTO.input.StudentInputDTO;
import com.example.block7crudvalidation.controller.DTO.output.EstudianteAsignaturaOutputDTO;
import com.example.block7crudvalidation.controller.DTO.output.PersonaOutputDto;
import com.example.block7crudvalidation.controller.DTO.output.ProfessorOutputDTO;
import com.example.block7crudvalidation.controller.DTO.output.StudentOutputDTO;
import com.example.block7crudvalidation.domain.EstudianteAsignatura;
import com.example.block7crudvalidation.domain.Persona;
import com.example.block7crudvalidation.domain.Professor;
import com.example.block7crudvalidation.domain.Student;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

    Mapper INSTANCE = Mappers.getMapper( Mapper.class );

    //PERSONA
    @Mapping(target = "id_persona", source = "id_persona")
    PersonaOutputDto personaToPersonaOutputDTO(Persona persona);
    @Mapping(target = "id_persona", source = "id_persona")
    Persona personaInputDTOtoPersona(PersonaInputDto personaInputDTO);

    //STUDENT
    @Mapping(source = "student_id", target = "student_id")
    Student studentToEntity(StudentInputDTO studentInputDTO);

    @Mapping(source = "student_id", target = "student_id")
    StudentOutputDTO StudentToOutputDTO(Student student);

    @Mapping(source = "student_id", target = "student_id")
    Student studentInputDTOtoStudent(StudentInputDTO studentInputDTO);

    //PROFESSOR
    @Mapping(source = "id_profesor", target = "id_profesor")
    Professor professorToEntity(ProfessorInputDTO professorInputDTO);
    @Mapping(source = "id_profesor", target = "id_profesor")
    ProfessorOutputDTO profesorToOutputDTO(Professor professor);

    @Mapping(source = "id_profesor", target = "id_profesor")
    Professor profesorInputDTOtoProfesor(ProfessorInputDTO professorInputDTOr);

    //ESTUDIANTE_ASIGNATURA
    @Mapping(source = "id_asignatura", target = "id_asignatura")
    EstudianteAsignatura EAtoEntity(EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO);

    @Mapping(source = "id_asignatura", target = "id_asignatura")
    EstudianteAsignaturaOutputDTO EAtoOutputDTO(EstudianteAsignatura estudianteAsignatura);

    @Mapping(source = "id_asignatura", target = "id_asignatura")
    EstudianteAsignatura EAInputFromDTO(EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO);
}
