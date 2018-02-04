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
 * Unit testing with without using spring boot dependency injection
 *
 * @author km185223
 */
public class ControllerUnitTest {

    /**
     * In unit test you can create instance of the service
     *
     * CalculatorService mockCalculatorService = new CalculatorServiceImpl();
     *
     * OR use mock for calculatorService
     */
    @Mock
    private CalculatorService mockCalculatorService;

    private HelloController helloController;

    /**
     * Use rule to add annotation on mocks
     */
    @Rule public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setup() {
        helloController = new HelloController(mockCalculatorService);
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
