package com.naresh.corejava.java8.streams;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Q2.Given a String, how do you find the character with the
second-highest frequency using Java 8 Streams?
 */
public class FindSecondHighFrequestNum {
    public static void main(String[] args) {
        String s = "abcdeabca";
        Map<Character, Long> frequencyMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Character second = frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Long> comparingByValue().reversed())
                .skip(1)
                .findFirst().get().getKey()
                ;
        System.out.println(second);

    }
}
