package com.chelsea.java8.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Nashorn JavaScript引擎
 * 
 * @author shevchenko
 *
 */
public class JavaScript {

    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        System.out.println(engine.getClass().getName());
        System.out.println("Result:" + engine.eval("function f() { return 1; }; f() + 2;"));
    }

}
