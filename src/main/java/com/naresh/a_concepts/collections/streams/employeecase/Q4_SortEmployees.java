package com.naresh.a_concepts.collections.streams.employeecase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 🔹 Q4. How do you sort a list of Employee objects by both name and
 * salary using Java 8?
 */
public class Q4_SortEmployees {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
                new Employee("Alex", 50000,null),
                new Employee("Bob", 60000, null),
                new Employee("Alex", 70000, null)
        );

        // Logic:
        // 1. Use Comparator.comparing() for the primary sort key (name).
        // 2. Use .thenComparing() for the secondary sort key (salary).
        list.stream()
                .sorted(Comparator
                        .comparing(Employee::getName)
                        .thenComparing(Employee::getSalary))
                .forEach(System.out::println);
        System.out.println("");
        list.stream()
                .sorted(Comparator
                        .comparing(Employee::getName)
                        .thenComparing(Employee::getSalary).reversed())
                .forEach(System.out::println);
        System.out.println("");
      list.stream()
              .sorted(Comparator
                      .comparing(Employee::getName)
                      .thenComparing(Comparator.comparingInt(Employee::getSalary).reversed()))
              .forEach(System.out::println);
    }
}

// Helper class for this example

