package com.naresh.outputs.factset;

import java.util.Objects;

/**
 * Demonstrates the difference between default object equality and custom, overridden equality.
 */
class Employee {
    private final int id;
    private final String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Overridden equals() for meaningful "validation" or equality check.
    @Override
    public boolean equals(Object o) {
        // 1. Reference check: Are they the exact same object?
        if (this == o) return true;

        // 2. Null and class check: Is the other object null or of a different type?
        if (o == null || getClass() != o.getClass()) return false;

        // 3. Cast and state comparison: Cast the object and compare the relevant fields.
        Employee employee = (Employee) o;
        return id == employee.id; // Two employees are equal if their IDs are the same.
    }

    // When you override equals(), you MUST override hashCode().
    @Override
    public int hashCode() {
        // Use a standard way to generate a hash code from the same fields used in equals().
        return Objects.hash(id);
    }
}

public class ObjectEquals {
    public static void main(String[] args) {
        // Create two different Employee objects, but with the same ID.
        Employee emp1 = new Employee(101, "Naresh");
        Employee emp2 = new Employee(101, "Suresh");

        System.out.println("--- Comparing two separate Employee objects with the same ID ---");

        // This will now be TRUE because we overrode equals() to check the 'id' field.
        if (emp1.equals(emp2)) {
            System.out.println("emp1.equals(emp2) is TRUE - The objects are considered equal.");
        } else {
            System.out.println("emp1.equals(emp2) is FALSE");
        }

        // This will still be FALSE because they are two different objects in memory.
        if (emp1 == emp2) {
            System.out.println("emp1 == emp2 is TRUE");
        } else {
            System.out.println("emp1 == emp2 is FALSE - They are not the same object in memory.");
        }
    }
}
