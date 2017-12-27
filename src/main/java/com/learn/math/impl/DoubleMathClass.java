package com.learn.math.impl;

import com.learn.math.DoubleBaseMath;
import org.springframework.stereotype.Component;

/**
 * @author kartik
 */
@Component
public class DoubleMathClass extends AbstractBaseMath<Double> implements DoubleBaseMath {

    @Override
    public Double multiply(Double a, Double b) {
        System.out.println("DoubleMathClass.multiply : "+a.getClass().getSimpleName());
        return a*b;
    }

    @Override
    public Double division(Double a, Double b) {
        System.out.println("DoubleMathClass.division : "+a.getClass().getSimpleName());
        return a/b;
    }

    @Override
    public Double mod(Double a, Double b) {
        System.out.println("DoubleMathClass.mod : "+a.getClass().getSimpleName());
        return a%b;
    }

    @Override
    public Double squareRoot(Double d) {
        System.out.println("DoubleMathClass.squareRoot : "+d.getClass().getSimpleName());
        return new Double(Math.sqrt(d));
    }
}
