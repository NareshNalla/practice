package com.naresh.concepts.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListToStringConverter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A"); list.add("B"); list.add("C");

        // 1. String.join (Java 8+)
        System.out.println(String.join(", ", list));

        // 2. Stream Collectors.joining (Java 8+)
        System.out.println(list.stream().collect(Collectors.joining(" | ")));

        // 3. Default toString()
        System.out.println(list.toString());
    }
}
