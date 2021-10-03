package com.jacektracz.java8_tutorial.javabasis;

public abstract class CalculatorFactory {

    public static Calculator getInstance() {
        return new BasicCalculator();
    }
}
