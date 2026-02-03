package com.naresh.corejava.java8.streams;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
/*
Given s = "abcd", how do you generate the pattern abbcccdddd using Java 8 Streams?
 */
public class GenerateIncremental {

    public static void main(String[] args) {
        String s = "abc";
       String res = IntStream.range(0, s.length())
                        .mapToObj( i -> String.valueOf(s.charAt(i)).repeat(i+1))
                .collect(Collectors.joining());
        System.out.println(res);
    }
}
