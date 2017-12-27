package com.learn.math.impl;

import com.learn.math.BaseMath;

/**
 * @author kartik
 */
public abstract class AbstractBaseMath<T extends Number> implements BaseMath<T> {
    @Override
    public T add(T a, T b) {
        System.out.println("AbstractBaseMath.add : "+a.getClass().getSimpleName());
        return a;
    }

    @Override
    public T subtract(T a, T b) {
        System.out.println("AbstractBaseMath.subtract : "+a.getClass().getSimpleName());
        return a;
    }
}
