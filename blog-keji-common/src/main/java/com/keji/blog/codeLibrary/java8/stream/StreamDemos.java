package com.keji.blog.codeLibrary.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by wb-ny291824 on 2017/8/17.
 * java8 stream demo
 */
public class StreamDemos {

    public static void main(String[] args) {

    }

    /**
     * 构造流的几种常见方式
     *
     */
    public void demo1() {
        //Individual values
        Stream stream = Stream.of("a", "b", 1);

        //Arrays
        String[] strings = {"a", "b", "c"};
        Stream stream1 = Stream.of(strings);
        Stream<String> stream2 = Arrays.stream(strings);

        //Collections
        List<String> stringList = Arrays.asList(strings);
        Stream<String> stream3 = stringList.stream();

        //Int Long Double  数值流的构造
        IntStream.of(new int[]{1,2,3})
                .forEach(System.out::println);
        IntStream.range(1,3)
                .forEach(System.out::println);
        IntStream.rangeClosed(1,3)
                .forEach(System.out::println);

        //流转换为其他数据结构
       String[] strArray1 = (String[]) stream.toArray(String[]::new);


    }

    /**
     * 转换大写
     */
//    public void demo2() {
//        ArrayList<Object> list = new ArrayList<>();
//        list.add("asd");
//        list.add("c");
//        list.add("B");
//
//        List<String> output = list.stream()
//                 .map(String::toUpperCase)
//                 .collect(Collectors.toList())
//        ;
//    }
}
