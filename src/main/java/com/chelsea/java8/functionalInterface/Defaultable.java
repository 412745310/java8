package com.chelsea.java8.functionalInterface;

public interface Defaultable {

    default String notRequired() {
        return "Default implementation";
    }

}
