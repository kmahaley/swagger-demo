package com.learn.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.learn.exception.CustomTestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author km185223
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/{id}")
    public String helloGet(@PathVariable("id") final String id) throws CustomTestException {
        final String methodName = " \n3) HelloController.helloGet ";
        List<Integer> integerList = new ArrayList<>();
        final List<Integer> integers = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 5, 4, 3);
        try {
            integerList = integers
                    .stream()
                    .map(s -> {
                        log.info(s.toString());
                        try {
                            if (s == 2) {
                                throw new CustomTestException("thread exception for 2");
                            } else {
                                return s * 10;
                            }
                        } catch (CustomTestException ex) {
//                            throw new RuntimeException(ex.getMessage());
                            return s * 2000;
                        }

                    })
                    .collect(Collectors.toList());
        } catch (RuntimeException ex) {
            log.info(ex.getMessage());
            log.info("Inside :" + integerList.toString());
            throw ex;
        }
        log.info("Outside " + integerList.toString());
        return id;
    }

    @PostMapping("/post")
    public String helloPost(@RequestBody final String id) {
        return id;
    }

    @PutMapping("/put")
    public String helloPut(@RequestBody final String id) {
        return id;
    }
}
