package com.learn.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.learn.model.Person;
import com.learn.model.PersonId;
import com.learn.service.JavaGenericsServiceImpl;
import com.learn.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PersonController implements PersonService {

    @Autowired
    JavaGenericsServiceImpl genericsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Person get(@PathVariable("id") PersonId id) {
//        genericsService.genericMethodForBox();
//        genericsService.genericMethodForMovie();
//        genericsService.inspect(20.22);
        Supplier<String> supplier = () -> "apple";
        System.out.println("------->   "+supplier.get().charAt(3));

        System.out.println("------->   "+supplier.get().charAt(4));

        // initial a Map
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "Jan");
        map.put("2", "Feb");
        map.put("3", "Mar");
        map.put("4", "Apr");
        map.put("5", "May");
        map.put("6", "Jun");



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
