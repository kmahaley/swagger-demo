package com.learn.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author km185223
 */
@RestController
@RequestMapping("/hello")
public class HelloResource {

    @GetMapping("/{id}")
    public String helloGet(@PathVariable("id") final String id){
        return id;
    }

    @PostMapping("/post")
    public String helloPost(@RequestBody final String id){
        return id;
    }

    @PutMapping("/put")
    public String helloPut(@RequestBody final String id){
        return id;
    }
}
