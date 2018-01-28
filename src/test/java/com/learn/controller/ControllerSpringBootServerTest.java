package com.learn.controller;/*
 * -----------------------------------------------------------------------------
 *  Copyright 2018 NCR Corporation
 * -----------------------------------------------------------------------------
 */

import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Run application on random port and test the outcome using {@link TestRestTemplate}
 *
 * @SpringBootTest = looks for @SpringBootApplication and starts up the main application on random web environment port
 * restTemplate send the request and assert the response received.
 *
 * In application logs you can see 'Tomcat started on port(s): <some port no>'
 *
 * @author km185223
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerSpringBootServerTest {

    @LocalServerPort
    private int port;

    private URL baseUrl;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception{
        baseUrl = new URL("http://localhost:" + port + "/hello/add/100/300");
    }

    @Test
    public void testHelloControllerAddition() throws Exception {

        final ResponseEntity<Integer> response = restTemplate
                .getForEntity(baseUrl.toString(), Integer.class);
        Assert.assertTrue(response.getStatusCode() == HttpStatus.OK);
        Assert.assertTrue(response
                .getBody()
                .intValue() == 400);
    }
}