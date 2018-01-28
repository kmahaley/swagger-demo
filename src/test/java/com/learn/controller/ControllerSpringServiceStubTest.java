package com.learn.controller;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Run test with profile "stub-test" name
 * Test code using Calculator service stub with spring context.
 *
 * @author km185223
 */
@ActiveProfiles("stub-test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerSpringServiceStubTest {

    @Autowired
    private HelloController helloController;

    @Autowired
    private Environment environment;

    @Before
    public void setUp() {
        final boolean inUnitTest = Arrays
                .stream(environment.getActiveProfiles())
                .anyMatch(s -> s.equalsIgnoreCase("unit-test"));

        Assert.assertTrue(helloController != null);
    }

    @Test
    public void testAddition() {
        Assert.assertEquals(12, helloController.add(12, 12));

    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionForArithmeticException() {
        helloController.divide(12, 0);
    }

    @Test
    public void testDivision() {
        Assert.assertEquals(5, helloController.divide(12, 12));

    }
}
