package com.learn.service;

import java.util.Map;

import com.learn.model.Person;
import com.learn.model.PersonId;
import com.learn.model.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kartik
 */
@Slf4j
@RestController
@RequestMapping("/services")
public class PersonServiceImpl implements PersonService {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Person get(@PathVariable("id") PersonId id) {
        return new Person(id, "GET", null, null, 20, null);
    }

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public Person create(@RequestBody Person person) {
        return new Person(person.getPersonId(), "CREATE", null, null, 20, null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    @Override
    public Person patch(@PathVariable("id") PersonId id, @RequestBody Map<String, Object> person) {
        return new Person(id, "PATCH", null, null, 20, null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @Override
    public Person update(@PathVariable("id") PersonId id, @RequestBody Person person) {
        return new Person(id, "UPDATE", null, null, 20, null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @Override
    public void delete(@PathVariable("id") PersonId id) {
        log.info("deleted : " + id.getId());
    }
}
