package com.jacektracz.java8_tutorial.javabasis;

public class App1 implements A {
    @Override
    public void doSth() {
        System.out.println("inside App1");
    }

    public static void main(String[] args) {
        new App1().doSth();
    }
}

interface A {
    default void doSth() {
        System.out.println("inside A");
    }
}
