package com.learn.exception.exceptionhandler;/*
 * -----------------------------------------------------------------------------
 *  Copyright 2018 NCR Corporation
 * -----------------------------------------------------------------------------
 */

import com.learn.exception.PersonAlreadyExistsException;
import com.learn.exception.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * TODO : add description
 */
@ControllerAdvice
public class PersonExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Object> exceptionNotFound(PersonNotFoundException exception) {
        return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PersonAlreadyExistsException.class)
    public ResponseEntity<Object> exception(PersonAlreadyExistsException exception) {
        return new ResponseEntity<>("Person already exists", HttpStatus.CONFLICT);
    }

}

