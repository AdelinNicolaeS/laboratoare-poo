package com.oop_pub.exceptions.ex2_3;

import java.util.Collection;

public class Operations implements Calculator {
    @Override
    public Double add(Double nr1, Double nr2) {
        if (nr1 == null || nr2 == null) {
            throw new NullParameterException();
        }
        if (nr1 + nr2 == Double.POSITIVE_INFINITY) {
            throw new OverflowException();
        } else if (nr1 + nr2 == Double.NEGATIVE_INFINITY) {
            throw new UnderflowException();
        }
        return nr1 + nr2;
    }

    @Override
    public Double divide(Double nr1, Double nr2) {
        if (nr1 == null || nr2 == null) {
            throw new NullParameterException();
        }
        if (nr1 + nr2 == Double.POSITIVE_INFINITY) {
            throw new OverflowException();
        } else if (nr1 + nr2 == Double.NEGATIVE_INFINITY) {
            throw new UnderflowException();
        }
        return nr1/nr2;
    }

    @Override
    public Double average(Collection<Double> numbers) {
        Double average = 0.0;
        Double count = 0.0;
        for (Double element : numbers) {
            average = add(average, element);
            count++;
        }
        average = divide(average, count);
        return average;
    }
}
