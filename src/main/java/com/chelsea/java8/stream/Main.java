package com.chelsea.java8.stream;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private final static Collection<Task> tasks = Arrays.asList(new Task(Status.OPEN, 5), new Task(Status.OPEN, 13),
            new Task(Status.CLOSED, 8));

    public static void main(String[] args) throws Exception {
        mapToInt();
        map();
        groupingBy();
        percent();
        file();
    }

    /**
     * 读取文件
     * 
     * @throws Exception
     */
    private static void file() throws Exception {
        Path path = new File("C:/Users/Administrator/Desktop/新建文本文档.txt").toPath();
        Files.lines(path, StandardCharsets.UTF_8).onClose(() -> System.out.println("Done!"))
                .forEach(System.out::println);
    }

    /**
     * 求points值所占百分比
     */
    private static void percent() {
        double totalPoints = tasks.stream().parallel().map(task -> task.getPoints()).reduce(0, Integer::sum);
        Collection<String> result = tasks.stream() // Stream< String >
                .mapToInt(Task::getPoints) // IntStream
                .asLongStream() // LongStream
                .mapToDouble(points -> points / totalPoints) // DoubleStream
                .boxed() // Stream< Double >
                .mapToLong(weigth -> (long) (weigth * 100)) // LongStream
                .mapToObj(percentage -> percentage + "%") // Stream< String>
                .collect(Collectors.toList()); // List< String >
        System.out.println(result);
    }

    /**
     * 根据status进行分组
     */
    private static void groupingBy() {
        Map<Status, List<Task>> map = tasks.stream().collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(map);
    }


    /**
     * 根据points求和
     */
    public static void map() {
        double totalPoints = tasks.stream().parallel().map(task -> task.getPoints()).reduce(0, Integer::sum);
        System.out.println(totalPoints);
    }

    /**
     * 过滤status并根据points求和
     */
    public static void mapToInt() {
        long totalPointsOfOpenTasks =
                tasks.stream().filter(task -> task.getStatus() == Status.OPEN).mapToInt(Task::getPoints).sum();
        System.out.println(totalPointsOfOpenTasks);
    }

}
