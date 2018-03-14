package com.chelsea.java8.type;

/**
 * 类型推断
 * 
 * @author shevchenko
 *
 * @param <T>
 */
public class Value<T> {

    public static <T> T defaultValue() {
        return null;
    }

    public T getOrDefault(T value, T defaultValue) {
        return (value != null) ? value : defaultValue;
    }

    public static void main(String[] args) {
        Value<String> value = new Value<>();
        String s = value.getOrDefault("22", Value.defaultValue());
        System.out.println(s);
    }

}
