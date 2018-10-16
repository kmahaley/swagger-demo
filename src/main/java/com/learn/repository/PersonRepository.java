package com.learn.repository;/*
 * -----------------------------------------------------------------------------
 *  Copyright 2018 NCR Corporation
 * -----------------------------------------------------------------------------
 */

import java.util.HashMap;
import java.util.Map;

import com.learn.exception.PersonAlreadyExistsException;
import com.learn.exception.PersonNotFoundException;
import com.learn.model.Person;
import org.springframework.stereotype.Repository;

/**
 * TODO : add description
 */
@Repository
public class PersonRepository {

    final Map<String, Person> map = new HashMap<>();

    public Person get(String id) {
        Person person = map.get(id);
        if (person == null) {
            throw new PersonNotFoundException();
        }
        return person;
    }

    public Person save(Person person) {
        if(map.containsKey(person.getPersonId().getId())){
            throw new PersonAlreadyExistsException();
        }
        map.put(person
                .getPersonId()
                .getId(), person);
        return person;
    }

    public Person delete(String id) {
        return map.remove(id);
    }

}
