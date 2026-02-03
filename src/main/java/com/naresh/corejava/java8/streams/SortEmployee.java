package com.naresh.corejava.java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortEmployee {
    public static void main(String[] args) {
        // Create a list of Employee objects
        List<Employee> elist = new ArrayList<>();
        elist.add(new Employee(1, "Naresh", 34, 5000));
        elist.add(new Employee(2, "Suresh", 30, 8000));
        elist.add(new Employee(3, "Naresh", 28, 6000)); // Same name, different salary
        elist.add(new Employee(4, "Mahesh", 35, 5000));

        System.out.println("Original list:");
        elist.forEach(System.out::println);

        System.out.println("\nSorted list by name then salary:");
        sortAndPrintEmployees(elist);
    }

    private static void sortAndPrintEmployees(List<Employee> elist) {
        elist.stream()
                .sorted(Comparator.comparing(Employee::name)
                        .thenComparing(Employee::salary))
                .forEach(System.out::println);
    }
}

// Correctly defined record for an immutable Employee object
record Employee(int id, String name, int age, double salary) {
}
