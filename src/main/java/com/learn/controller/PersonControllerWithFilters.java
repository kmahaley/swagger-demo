package com.learn.controller;/*
 * -----------------------------------------------------------------------------
 *  Copyright 2018 NCR Corporation
 * -----------------------------------------------------------------------------
 */

import java.util.Map;
import javax.websocket.server.PathParam;

import com.learn.model.Person;
import com.learn.model.PersonId;
import com.learn.service.PersonService;
import com.learn.service.impl.DomainPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO : add description
 */
@Slf4j
@RestController
@RequestMapping("/filter/persons")
public class PersonControllerWithFilters implements PersonService {

    DomainPersonService domainPersonService;

    @Autowired
    public PersonControllerWithFilters(DomainPersonService domainPersonService) {
        this.domainPersonService = domainPersonService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Person get(PersonId id) {
        return domainPersonService.domainGet(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public Person create(@RequestBody Person person) {
        return domainPersonService.domainCreate(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    @Override
    public Person patch(@PathParam("id") PersonId id, @RequestBody Map<String, Object> persons) {
        return domainPersonService.domainPatch(id, persons);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @Override
    public Person update(@PathParam("id") PersonId id, @RequestBody Person person) {
        return domainPersonService.domainUpdate(id, person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @Override
    public void delete(@PathParam("id") PersonId id) throws Exception {
        domainPersonService.domainDelete(id);
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @Override
    public Person getString(@RequestBody Person person) {
        throw new UnsupportedOperationException();
    }

}
