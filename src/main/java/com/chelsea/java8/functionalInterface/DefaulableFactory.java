package com.chelsea.java8.functionalInterface;

import java.util.function.Supplier;

import com.chelsea.java8.functionalInterface.impl.DefaultableImpl;
import com.chelsea.java8.functionalInterface.impl.OverridableImpl;

/**
 * 接口的默认方法和静态方法
 * 
 * @author shevchenko
 *
 */
public class DefaulableFactory {

    public static Defaultable create(Supplier<Defaultable> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        Defaultable defaultable1 = DefaulableFactory.create(() -> new DefaultableImpl());
        String s1 = defaultable1.notRequired();
        Defaultable defaultable2 = DefaulableFactory.create(OverridableImpl::new);
        String s2 = defaultable2.notRequired();
        System.out.println(s1);
        System.out.println(s2);
    }

}
