package com.learn.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import com.learn.model.Person;
import com.learn.model.PersonId;
import com.learn.service.PersonService;
import com.learn.service.impl.JavaGenericsServiceImpl;
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

    JavaGenericsServiceImpl genericsService;

    @Autowired
    public PersonController(JavaGenericsServiceImpl genericsService) {
        this.genericsService = genericsService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Person get(@PathVariable("id") PersonId id) {
//        genericsService.genericMethodForBox();
//        genericsService.genericMethodForMovie();
//        genericsService.inspect(20.22);
//        Supplier<String> supplier = () -> "apple";
//        System.out.println("------->   "+supplier.get().charAt(3));
//        System.out.println("------->   "+supplier.get().charAt(4));

        // initial a Map
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "Jan");
        map.put("2", "Feb");
        map.put("3", "Mar");
        map.put("4", "Apr");
        map.put("5", "May");
        map.put("6", "Jun");

        List<Person> persons = Arrays.asList(
                new Person(id, "John", null, null, 40, null),
                new Person(id, "John", null, null, 50, null),
                new Person(id, "mario", null, null, 305, null),
                new Person(id, "merry", null, null, 202, null));
        final Double average = persons
                .stream()
                .collect(Collectors.averagingInt(p -> p.getAge()));
        System.out.println("Average : " + average);

        List<String> mappingByFunction = persons
                .stream()
                .collect(Collectors.mapping((s -> s.getName()), Collectors.toList()));
        System.out.println("Mapping : " + mappingByFunction);

        Map<String, Integer> stringIntegerMap = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.getName(), Collectors.summingInt(p -> p.getAge())));
        System.out.println("Group by : " + stringIntegerMap);

        Map<String, List<Integer>> mapName = persons
                .stream()
                .collect(Collectors.groupingBy(
                        Person::getName,
                        Collectors.mapping(Person::getAge, Collectors.toList())));
        System.out.println("mapName : " + mapName);

        BiFunction<Double, Double, String> function = (a, b) -> "apple " + (a.intValue() + b.intValue());
        final String apply = function.apply(2.0, 3.0);

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
    public void delete(@PathVariable("id") PersonId id) throws Exception {
        log.info("deleted : " + id.getId());
        genericsService.whichMethodException("exception");
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @Override
    public Person getString(@RequestBody Person person) {
        log.info("/person : " + person);
        return person;
    }
}
