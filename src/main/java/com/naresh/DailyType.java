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

        //record java 16+
        record Person(String name, int age){
            Person{
                if(age>0) throw new IllegalArgumentException("age<0");
            }
        }
        var person = new Person("Naresh", 35);
        var person1 = new Person("Test", 0);
        System.out.println(person.name()); //not getName()
        System.out.println(person1);
        //SEALED class and pattern matching
        Shape shape = new Circle(5.0);
        if (shape instanceof Circle cir) {//java 17
            System.out.println(shape);
        }
        double area = switch(shape){ //exaustive - no default needed
            case Circle cir -> Math.PI * cir.r() * cir.r();
            case Rect rec -> rec.w * rec.h;
        };


    }
    sealed interface Shape permits Circle, Rect {}
    record Circle(double r) implements Shape {}
    record Rect(double w, double h) implements Shape {}
}
