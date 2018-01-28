package com.learn.service.impl;

import com.learn.service.CalculatorService;

/**
 * Stub of {@link CalculatorService}
 *
 * @author km185223
 */

public class CalculatorServiceStub implements CalculatorService {
    @Override
    public int add(int input1, int input2) {
        return 12;
    }

    @Override
    public int subtract(int input1, int input2) {
        return 8;
    }

    @Override
    public int multiply(int input1, int input2) {
        return 20;
    }

    @Override
    public int divide(int input1, int input2) {
        if(input2 == 0)
            throw new ArithmeticException();
        return 5;
    }
}
