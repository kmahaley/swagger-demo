package com.learn.controller;

import com.learn.service.CalculatorService;
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

    private CalculatorService calculatorService;


    public HelloController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add/{var1}/{var2}")
    public int add(@PathVariable("var1") int var1, @PathVariable("var2") int var2) {
        final String methodName = " \n3) HelloController.helloGet ";
        return calculatorService.add(var1, var2);
    }

    @GetMapping("/substract/{var1}/{var2}")
    public int subtract(@PathVariable("var1") int var1, @PathVariable("var2") int var2) {
        final String methodName = " \n3) HelloController.helloGet ";
        return calculatorService.subtract(var1, var2);
    }

    @GetMapping("/multiply/{var1}/{var2}")
    public int multiply(@PathVariable("var1") int var1, @PathVariable("var2") int var2) {
        final String methodName = " \n3) HelloController.helloGet ";
        return calculatorService.multiply(var1, var2);
    }

    @GetMapping("/divide/{var1}/{var2}")
    public int divide(@PathVariable("var1") int var1, @PathVariable("var2") int var2) {
        final String methodName = " \n3) HelloController.helloGet ";
        return calculatorService.divide(var1, var2);
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
