package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.controller.DTO.input.PersonaInputDto;
import com.example.block7crudvalidation.controller.DTO.output.PersonaOutputDto;
import com.example.block7crudvalidation.domain.Persona;
import org.springframework.data.domain.Pageable;
import com.example.block7crudvalidation.repository.PersonaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private EntityMapper entityMapper;

    public PersonaServiceImpl(PersonaRepository personaRepository, EntityMapper entityMapper) {
        this.personaRepository = personaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public PersonaOutputDto findById(int id) throws Exception {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new Exception("Persona not found with ID: " + id));
        return entityMapper.toPersonaDTO(persona);
    }

    @Override
    public PersonaOutputDto findByUsuario(String usuario) throws Exception {
        Persona persona = personaRepository.findByUsuario(usuario)
                .orElseThrow(() -> new Exception("Persona not found with usuario: " + usuario));
        return entityMapper.toPersonaDTO(persona);
    }

    @Override
    public List<PersonaOutputDto> findAll() {
        List<Persona> personas = personaRepository.findAll();
        return personas.stream()
                .map(entityMapper::toPersonaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonaOutputDto save(PersonaInputDto personaInputDTO) throws Exception {
        Persona persona = entityMapper.toPersonaEntity(personaInputDTO);
        persona = personaRepository.save(persona);
        return entityMapper.toPersonaDTO(persona);
    }

    //PARTE DE CORS
    @Override
    public void addPerson(PersonaInputDto personaInputDto) {
        Persona person = entityMapper.toPersonaEntity(personaInputDto);
        personaRepository.save(person);
    }

    @Override
    public List<PersonaOutputDto> getAllPersons() {
        List<Persona> personas = personaRepository.findAll();
        return personas.stream()
                .map(entityMapper::toPersonaDTO)
                .collect(Collectors.toList());
    }

    //PARTE DE CRITERIABUILDER
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PersonaOutputDto> searchByCriteria(String usuario, String name, String surname, Date fechaInicio, Date fechaFin, String sortField, Pageable pageable) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);

        Root<Persona> persona = cq.from(Persona.class);
        List<Predicate> predicates = new ArrayList<>();

        if (usuario != null) {
            predicates.add(cb.equal(persona.get("usuario"), usuario));
        }

        if (name != null) {
            predicates.add(cb.equal(persona.get("name"), name));
        }

        if (surname != null) {
            predicates.add(cb.equal(persona.get("surname"), surname));
        }

        if (fechaInicio != null) {
            predicates.add(cb.greaterThanOrEqualTo(persona.get("created_date"), fechaInicio));
        }

        if (fechaFin != null) {
            predicates.add(cb.lessThanOrEqualTo(persona.get("created_date"), fechaFin));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        if (sortField != null) {
            cq.orderBy(cb.asc(persona.get(sortField)));
        }

        TypedQuery<Persona> query = entityManager.createQuery(cq);
        query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());

        List<Persona> personas = query.getResultList();
        return personas.stream()
                .map(entityMapper::toPersonaDTO)
                .collect(Collectors.toList());
    }
}
