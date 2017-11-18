package com.learn.model;

import java.util.Map;

/**
 * @author kartik
 */
public interface PersonService {

    Person get(PersonId id);

    Person create(Person person);

    Person patch(PersonId id, Map<String, Object> person);

    Person update(PersonId id, Person person);

    void delete(PersonId id);
}
