package com.learn.math;

/**
 * @author kartik
 */
public interface BaseMath<T extends Number> {

    T add(T a, T b);

    T subtract(T a, T b);

    T multiply(T a, T b);

    T division(T a, T b);

    T mod(T a, T b);
}
