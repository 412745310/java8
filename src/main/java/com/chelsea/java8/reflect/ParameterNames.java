package com.chelsea.java8.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 反射参数方法
 * 
 * @author shevchenko
 *
 */
public class ParameterNames {

    public static void main(String[] args) throws Exception {
        Method method = ParameterNames.class.getMethod("main", String[].class);
        for (final Parameter parameter : method.getParameters()) {
            System.out.println("Parameter: " + parameter.getName());
        }
    }

}
