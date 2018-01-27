package com.learn.controller;

import com.learn.service.CalculatorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;

/**
 * @author km185223
 */
public class HelloControllerTest {

    private HelloController helloController;

    @Mock
    private CalculatorService mockCalculatorService;

    /**
     * Use rule to add annotation on mocks
     */
    @Rule public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setup() {
        helloController = new HelloController(mockCalculatorService);
    }

    @Test
    public void testAddition() {
        //Defines the behaviour of external dependency
        when(mockCalculatorService.add(anyInt(),anyInt())).thenReturn(30);

        Assert.assertEquals(30, helloController.helloGet(12, 12));

        //To check if the method on mock is called
        verify(mockCalculatorService).add(anyInt(),anyInt());
        verify(mockCalculatorService, atLeastOnce()).add(anyInt(),anyInt());
    }
}
