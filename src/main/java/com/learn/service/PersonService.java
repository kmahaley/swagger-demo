package com.learn.service;

import java.util.Map;

import com.learn.model.Person;
import com.learn.model.PersonId;

/**
 * @author kartik
 */
public interface PersonService {

    Person get(PersonId id);

    Person create(Person person);

    Person patch(PersonId id, Map<String, Object> person);

    Person update(PersonId id, Person person);

    void delete(PersonId id) throws Exception;

    Person getString(Person p);
}
