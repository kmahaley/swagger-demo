package com.learn.service.impl;/*
 * -----------------------------------------------------------------------------
 *  Copyright 2018 NCR Corporation
 * -----------------------------------------------------------------------------
 */

import java.util.Map;

import com.learn.model.Person;
import com.learn.model.PersonId;
import com.learn.repository.PersonRepository;
import org.springframework.stereotype.Service;

/**
 * TODO : add description
 */
@Service
public class DomainPersonService {

    PersonRepository repository;

    public DomainPersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person domainGet(PersonId id) {
        return repository.get(id.getId());

    }

    public Person domainCreate(Person person) {
        return repository.save(person);
    }

    public Person domainPatch(PersonId id, Map<String, Object> person) {
        throw new UnsupportedOperationException();
    }

    public Person domainUpdate(PersonId id, Person newPerson) {
        final Person savedPerson = domainGet(id);
        newPerson.setPersonId(savedPerson.getPersonId());
        return repository.save(newPerson);
    }

    public void domainDelete(PersonId id) {
        repository.delete(id.getId());
    }
}
