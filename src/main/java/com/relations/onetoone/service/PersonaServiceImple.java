package com.relations.onetoone.service;

import com.relations.onetoone.model.Persona;
import com.relations.onetoone.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImple implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public Persona savePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona getPersona(Long idPersona) {
        return personaRepository.findById(idPersona).get();
    }

    @Override
    public List<Persona> getPersonas() {
        List<Persona> personaList = personaRepository.findAll();
        return personaList;
    }

    @Override
    public Persona updatePersona(Long idPersona, Persona persona) {
        Persona person = personaRepository.findById(idPersona).get();
        person.setIdPersona(persona.getIdPersona());
        person.setName(persona.getName());
        person.setAddress(persona.getAddress());
        return personaRepository.save(person);

    }

    @Override
    public Persona deletePersona(Long idPersona) {
        Persona person = personaRepository.findById(idPersona).get();
        personaRepository.deleteById(idPersona);
        return person;
    }
}
