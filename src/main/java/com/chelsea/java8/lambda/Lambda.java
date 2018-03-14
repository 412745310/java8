package com.chelsea.java8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Lambda表达式
 * 
 * @author shevchenko
 *
 */
public class Lambda {

    public static void main(String[] args) {
        // 循环遍历list
        Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));
        Arrays.asList("a", "b", "d").forEach(e -> {
            System.out.print(e);
            System.out.println(e);
        });
        String separator = ",";
        Arrays.asList("a", "b", "d").forEach((String e) -> System.out.println(e + separator));
        // list排序
        List<Integer> list = Arrays.asList(3, 1, 4);
        list.sort((e1, e2) -> e1.compareTo(e2));
        System.out.println(list);
        
    }

}
