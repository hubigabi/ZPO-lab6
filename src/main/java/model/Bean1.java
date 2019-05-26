package model;

import annotation.Scheduled;

public class Bean1 {
    private int counter1;
    private int counter2;

    public Bean1() {
        counter1 = 0;
        counter2 = 0;
    }

    @Scheduled(period = 1000L)
    public void method1() {
        System.out.println("Bean 1, method 1, iteration: " + ++counter1);
    }

    @Scheduled(period = 2000L)
    public void method2() {
        System.out.println("Bean 1, method 2, iteration: " + ++counter2);
    }
}
