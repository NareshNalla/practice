package com.naresh.collections.streams;

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
                new Employee("Alex", 50000),
                new Employee("Bob", 60000),
                new Employee("Alex", 70000)
        );

        // Logic:
        // 1. Use Comparator.comparing() for the primary sort key (name).
        // 2. Use .thenComparing() for the secondary sort key (salary).
        list.stream()
                .sorted(Comparator.comparing(Employee::getName)
                        .thenComparing(Employee::getSalary))
                .forEach(System.out::println);
    }
}

// Helper class for this example
class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
