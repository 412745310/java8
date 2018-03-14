package com.chelsea.java8.date;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTime日期类的使用
 * 
 * @author shevchenko
 *
 */
public class DateUtil {

    private final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获得当前时间字符串
     * 
     * @return
     */
    public static String getCurrentTimeString() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(TIME_FORMAT));
    }

    /**
     * 获得时间间隔
     * 
     * @param from
     * @param to
     * @return
     */
    public static Duration getTimeBetween(LocalDateTime from, LocalDateTime to) {
        return Duration.between(from, to);
    }

    public static void main(String[] args) {
        System.out.println(getCurrentTimeString());
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = LocalDateTime.now();
        Duration duration = getTimeBetween(from, to);
        System.out.println(duration.toNanos());
    }

}
