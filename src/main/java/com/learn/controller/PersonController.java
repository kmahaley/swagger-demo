package com.learn.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.learn.model.Address;
import com.learn.model.Gender;
import com.learn.model.ManifestData;
import com.learn.model.PackageData;
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
@RequestMapping("/persons")
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

        List<Address> addresses = getAddesses();

        List<Person> persons = Arrays.asList(
                new Person(id, "John", addresses.get(0), getManifestData(), 40, Gender.MALE),
                new Person(id, "John", addresses.get(1), null, 50, Gender.MALE),
                new Person(id, "mario", addresses.get(2), null, 305, Gender.FEMALE),
                new Person(id, "merry", addresses.get(3), getManifestData(), 202, Gender.FEMALE),
                new Person(id, "merry", addresses.get(4), null, 202, Gender.FEMALE));

        final Double average = persons
                .stream()
                .collect(Collectors.averagingInt(p -> p.getAge()));
        System.out.println("Collectors.averagingInt : " + average);

        final Long no = persons
                .stream()
                .collect(Collectors.counting());
        System.out.println("No of elements : " + no);

        List<String> mappingByFunction = persons
                .stream()
                .collect(Collectors.mapping((s -> s.getName()), Collectors.toList()));
        System.out.println("Collectors.mapping : " + mappingByFunction);

        final Map<String, List<Person>> personNameList = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.getName()));
        System.out.println("Collectors.groupingBy : " + personNameList);

        Map<String, Integer> personNameByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.getName(), Collectors.summingInt(p -> p.getAge())));
        System.out.println("Collectors.groupingBy sum of age : " + personNameByAge);

        Map<String, List<Integer>> personNameByAgeList = persons
                .stream()
                .collect(Collectors.groupingBy(
                        Person::getName,
                        Collectors.mapping(Person::getAge, Collectors.toList())));
        System.out.println("personNameByAgeList : " + personNameByAgeList);

        BiFunction<Double, Double, String> function = (a, b) -> "apple " + (a.intValue() + b.intValue());
        final String apply = function.apply(2.0, 3.0);

        final String CollectAndThen = persons
                .stream()
                .collect(Collectors.collectingAndThen(Collectors.summingInt(p -> p
                        .getAddress()
                        .getZip()), var -> "Zip " + var));
        System.out.println("CollectAndThen : " + CollectAndThen);

        final Double totalWeight = persons
                .stream()
                .flatMap(p -> {
                    if (p.getManifest() != null) {
                        return p
                                .getManifest()
                                .getPackages()
                                .stream();
                    }
                    return Stream.empty();
                })
                .collect(Collectors.summingDouble(packageData -> packageData.getWeight()));
        System.out.println("totalWeight : " + totalWeight);

        final Map<String, List<PackageData>> mapOfPackageName = persons
                .stream()
                .flatMap(p -> {
                    if (p.getManifest() != null) {
                        return p
                                .getManifest()
                                .getPackages()
                                .stream();
                    }
                    return Stream.empty();
                })
                .collect(Collectors.groupingBy(pd -> pd.getName()));
        System.out.println("mapOfPackageName : " + mapOfPackageName);

        final Map<String, Double> mapOfPackageWeight = persons
                .stream()
                .flatMap(p -> {
                    if (p.getManifest() != null) {
                        return p
                                .getManifest()
                                .getPackages()
                                .stream();
                    }
                    return Stream.empty();
                })
                .collect(Collectors.groupingBy(pd -> pd.getName(), Collectors.summingDouble(pd -> pd.getWeight())));
        System.out.println("mapOfPackageWeight : " + mapOfPackageWeight);

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

    private static ManifestData getManifestData() {
        PackageData package1 = new PackageData("TV", 222.0, 30.0, true);
        PackageData package2 = new PackageData("radio", 20.0, 10.0, true);
        PackageData package3 = new PackageData("fridge", 500.0, 50.0, false);
        ManifestData manifestData = new ManifestData();
        manifestData.setCurrencyCode("USD");
        manifestData.setTotalValue("10000");
        manifestData.setPackages(Arrays.asList(package1, package2, package3));
        return manifestData;
    }

    public List<Address> getAddesses() {
        Address address1 = new Address("street1", "city1", "state1", 00001, "country1");
        Address address2 = new Address("street2", "city2", "state2", 00002, "country2");
        Address address3 = new Address("street3", "city3", "state3", 00003, "country3");
        Address address4 = new Address("street4", "city4", "state4", 00004, "country4");
        Address address5 = new Address("street5", "city5", "state5", 00005, "country5");
        return Arrays.asList(address1, address2, address3, address4, address5);
    }
}
