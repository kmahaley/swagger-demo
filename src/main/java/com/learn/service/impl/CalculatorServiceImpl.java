package com.learn.service.impl;

import com.learn.service.CalculatorService;
import org.springframework.stereotype.Service;

/**
 * @author km185223
 */
@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public int add(int input1, int input2) {
        return input1+input2;
    }

    @Override
    public int subtract(int input1, int input2) {
        return input1-input2;
    }

    @Override
    public int multiply(int input1, int input2) {
        return input1*input2;
    }

    @Override
    public int divide(int input1, int input2) {
        return input1/input2;
    }
}
