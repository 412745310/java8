package com.chelsea.java8.method;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 方法引用
 * 
 * @author shevchenko
 *
 */
public class Car {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.getName());
    }

    public void follow(Car another) {
        System.out.println("Following the " + another.getName());
    }

    public void repair() {
        System.out.println("Repaired " + this.getName());
    }

    public static void main(String[] args) {
        Car car1 = Car.create(Car::new);
        car1.setName("car1");
        Car car2 = Car.create(Car::new);
        car2.setName("car2");
        List<Car> cars = Arrays.asList(car1);
        cars.forEach(Car::collide);
        cars.forEach(Car::repair);
        cars.forEach(car2::follow);
    }

}
