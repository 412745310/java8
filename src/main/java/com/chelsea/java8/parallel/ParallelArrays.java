package com.chelsea.java8.parallel;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 并行数组
 * 
 * @author shevchenko
 *
 */
public class ParallelArrays {

    public static void main(String[] args) {
        long[] arrayOfLong = new long[20000];
        Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
        System.out.println();
        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
    }

}
