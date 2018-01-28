package com.learn.controller;/*
 * -----------------------------------------------------------------------------
 *  Copyright 2018 NCR Corporation
 * -----------------------------------------------------------------------------
 */

import com.learn.service.CalculatorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * Unit testing with spring boot dependency injection
 *
 * @author km185223
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerSpringContextTest {

    @Mock
    private CalculatorService mockCalculatorService;

    @InjectMocks
    @Autowired
    private HelloController helloController;

    /**
     * Use rule to add annotation on mocks
     */
    @Rule public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        Assert.assertTrue(helloController != null);
    }

    @Test
    public void testAddition() {
        //Defines the behaviour of external dependency
        when(mockCalculatorService.add(anyInt(), anyInt())).thenReturn(30);

        Assert.assertEquals(30, helloController.add(12, 12));

        //To check if the method on mock is called
        verify(mockCalculatorService).add(anyInt(), anyInt());
        verify(mockCalculatorService, atLeastOnce()).add(anyInt(), anyInt());
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionForArithmeticException() {
        //Defines the behaviour of external dependency with argument as anyInt and eq
        when(mockCalculatorService.divide(anyInt(), eq(0))).thenThrow(new ArithmeticException());

        helloController.divide(100, 0);
        helloController.divide(12, 0);
        verify(mockCalculatorService, times(2)).divide(anyInt(), anyInt());
    }
}
