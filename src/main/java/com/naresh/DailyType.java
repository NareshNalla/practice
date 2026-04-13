package com.naresh;
import  java.util.*;
import java.util.stream.*;

public class DailyType {
    public static void main(String[] args){
        List<String> names = List.of("Naresh", "Nirva","Riya","Mouni");

        //Filter, transform, collect
        names.stream()
                .filter(n -> n.startsWith("N"))
                .map(String::toUpperCase)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        System.out.println(names);
        //groupping
        Map<Integer, List<String>> byLength = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(byLength);

        //joined
        String joined = names.stream()
                .collect(Collectors.joining(",","[","]"));

        System.out.println(joined);

        //java 16+
        record Person(String name, int age){}
        var person = new Person("Naresh", 35);
        System.out.println(person);
    }
}
