package com.chelsea.java8.functionalInterface.impl;

import com.chelsea.java8.functionalInterface.Defaultable;

public class OverridableImpl implements Defaultable {

    @Override
    public String notRequired() {
        return "Overridden implementation";
    }

}
