package com.learn.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.learn.math.impl.DoubleMathClass;
import com.learn.math.impl.IntegerMathClass;
import com.learn.model.generics.Box;
import com.learn.model.generics.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kartik
 */
@Slf4j
@Service
public class JavaGenericsServiceImpl {

    private DoubleMathClass doubleMathClass;

    private IntegerMathClass integerMathClass;

    @Autowired
    public JavaGenericsServiceImpl(DoubleMathClass doubleMathClass, IntegerMathClass integerMathClass) {
        this.doubleMathClass = doubleMathClass;
        this.integerMathClass = integerMathClass;
    }

    public void genericMethodForBox() {
        final Box<String> stringBox = new Box<>();
        stringBox.setName("StringBox");
        stringBox.setContents(Arrays.asList("s1", "s2", "s3", "s4"));

        final Box<Integer> integerBox = new Box<>();
        integerBox.setName(123456);
        integerBox.setContents(Arrays.asList(1, 2, 3, 4, 5));

        final Box<String> stringBox2 = new Box<>();
        stringBox2.setName("StringBox");
        stringBox2.setContents(Arrays.asList("s6", "s7", "s8", "s9"));

        List<Box<String>> boxes = new ArrayList<>(Arrays.asList(stringBox, stringBox2));
        log.info(boxes.toString() + "\n\n\n");

        log.info(stringBox + "\n" + integerBox);
    }

    public void genericMethodForMovie() {
        final Movie<String, Double, String, Boolean> dieHard = new Movie<>();
        dieHard.setIsAdult(false);
        dieHard.setCollection(20000.345);
        dieHard.setName("Die Hard 4.0");
        dieHard.setNameOfCasts(Arrays.asList("Matt", "Brad", "Jennifer"));

        final Movie genericMovie = new Movie();
        genericMovie.setName("Generic Movie");
        genericMovie.setCollection(12345.3344);
        genericMovie.setNameOfCasts(Arrays.asList("s1", "s2", "s3", 1233));
        genericMovie.setIsAdult(true);

        log.info("\n" + dieHard + "\n" + genericMovie);
    }

    public <U extends Number> void inspect(U u) {
        final int a = 20;
        final int b = 40;
        final Class<? extends Number> aClass = u.getClass();
        final boolean primitive = aClass.isPrimitive();
        log.info(aClass.toString() + " ---> " + primitive);
        log.info("---->" + (u.intValue() + a));

        integerMathClass.add(a, b);
        integerMathClass.division(a, b);
        integerMathClass.square(a);

        final double d =20.2000;
        final double c =40.4000;
        doubleMathClass.add(c,d);
        doubleMathClass.division(c,d);
        doubleMathClass.squareRoot(c);
    }

}
