package model;

import annotation.Scheduled;

public class Bean2 {
    private int counter1;
    private int counter2;

    public Bean2() {
        counter1 = 0;
        counter2 = 0;
    }

    @Scheduled(period = 3000L)
    public void method1() {
        System.out.println("Bean 2 , method 1, iteration: " + ++counter1);
    }

    @Scheduled(period = 4000L)
    public void method2() {
        System.out.println("Bean 2, method 2, iteration: " + ++counter2);
    }
}
