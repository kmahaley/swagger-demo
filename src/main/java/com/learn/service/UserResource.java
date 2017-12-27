package com.learn.service;

import java.util.Arrays;
import java.util.List;

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
@RequestMapping("/user")
public class UserResource {

    @GetMapping("/{id}")
    public List<String> userGet(@PathVariable("id") final String id){
        return Arrays.asList("apple","kiwi","mango");
    }

    @PostMapping("/post")
    public List<Double> userPost(){
        return Arrays.asList(2.0,3.8);
    }

    @PutMapping("/put")
    public String userPut(@RequestBody final String id){
        return id;
    }
}
