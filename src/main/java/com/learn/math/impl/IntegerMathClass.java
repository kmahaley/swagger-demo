package com.learn.math.impl;

import com.learn.math.IntegerBaseMath;
import org.springframework.stereotype.Component;

/**
 * @author kartik
 */
@Component
public class IntegerMathClass extends AbstractBaseMath<Integer> implements IntegerBaseMath {
    @Override
    public Integer multiply(Integer a, Integer b) {
        System.out.println("IntegerMathClass.multiply : "+ a.getClass().getSimpleName());
        return a*b;
    }

    @Override
    public Integer division(Integer a, Integer b) {
        System.out.println("IntegerMathClass.division : "+ a.getClass().getSimpleName());
        return a/b;
    }

    @Override
    public Integer mod(Integer a, Integer b) {
        System.out.println("IntegerMathClass.mod : "+ a.getClass().getSimpleName());
        return a%b;
    }

    @Override
    public Integer square(Integer i) {
        System.out.println("IntegerMathClass.square : "+ i.getClass().getSimpleName());
        return i*i;
    }
}
