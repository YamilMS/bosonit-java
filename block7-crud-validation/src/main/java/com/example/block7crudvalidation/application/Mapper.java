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

@org.mapstruct.Mapper
public interface Mapper {

    Mapper INSTANCE = Mappers.getMapper( Mapper.class );

    //PERSONA
    @Mapping(target = "id_persona", source = "id_persona")
    PersonaOutputDto personaToPersonaOutputDTO(Persona persona);
    @Mapping(target = "id_persona", source = "id_persona")
    Persona personaInputDTOtoPersona(PersonaInputDto personaInputDTO);

    //STUDENT
    @Mapping(source = "studentId", target = "id")
    Student studentToEntity(StudentInputDTO studentInputDTO);

    @Mapping(source = "id", target = "studentId")
    StudentOutputDTO StudentToOutputDTO(Student student);

    @Mapping(source = "studentId", target = "id")
    void studentInputDTOtoStudent(StudentInputDTO studentInputDTO);

    //PROFESSOR
    @Mapping(source = "professorId", target = "id")
    Professor professorToEntity(ProfessorInputDTO professorInputDTO);
    @Mapping(source = "id", target = "professorId")
    ProfessorOutputDTO profesorToOutputDTO(Professor professor);

    @Mapping(source = "professorId", target = "id")
    void profesorInputDTOtoProfesor(ProfessorInputDTO professorInputDTOr);

    //ESTUDIANTE_ASIGNATURA
    @Mapping(source = "id_asignatura", target = "id")
    EstudianteAsignatura EAtoEntity(EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO);

    @Mapping(source = "id", target = "id_asignatura")
    EstudianteAsignaturaOutputDTO EAtoOutputDTO(EstudianteAsignatura estudianteAsignatura);

    @Mapping(source = "id_asignatura", target = "id")
    void EAInputFromDTO(EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO);
}
