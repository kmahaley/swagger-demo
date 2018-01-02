package com.learn.controller;

import java.util.Arrays;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author km185223
 */
@RestController
@RequestMapping("/user")
@Api(value="User resource", description="Operations pertaining to user resource")
public class UserController {

    @ApiOperation(value = "View a list of available users", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{id}")
    @ResponseBody
    public List<String> userGet(@PathVariable("id") final String id){
        return Arrays.asList("apple","kiwi","mango");
    }

    @PostMapping("/post")
    @ResponseBody
    public List<Double> userPost(){
        return Arrays.asList(2.0,3.8);
    }

    @PutMapping("/put")
    @ResponseBody
    public Object userPut(@RequestBody final Object stringStringHashMap){
//        final HashMap<String, Object> stringStringHashMap = new HashMap<>(map);
        System.out.println(stringStringHashMap.toString());
        return stringStringHashMap;

    }
}
