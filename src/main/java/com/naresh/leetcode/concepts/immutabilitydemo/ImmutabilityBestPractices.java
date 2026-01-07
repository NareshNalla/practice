package com.naresh.leetcode.concepts.immutabilitydemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the difference between a flawed and a correct immutable class in Java.
 */
public class ImmutabilityBestPractices {

    public static void main(String[] args) {
        // 1. Flawed "Immutable" Class Demonstration
        List<Integer> originalMarks = new ArrayList<>(Arrays.asList(90, 85, 88));
        FlawedImmutableStudent student = new FlawedImmutableStudent("Alex", originalMarks);
        System.out.println("Flawed Student (Before): " + student.getMarks());

        originalMarks.add(70);         // External list modification
        student.getMarks().set(0, 50); // Getter modification

        System.out.println("Flawed Student (After):  " + student.getMarks()); // State has changed

        // 2. Truly Immutable Record Demonstration
        List<Integer> originalGrades = new ArrayList<>(Arrays.asList(90, 85, 88));
        TrulyImmutablePerson person = new TrulyImmutablePerson("Maria", originalGrades);
        System.out.println("True Record (Before):    " + person.grades());

        originalGrades.add(70); // Attempt to modify via original list
        try {
            person.grades().add(50); // Attempt to modify via accessor
        } catch (UnsupportedOperationException e) {
            // Expected: The list returned by the record is unmodifiable.
        }

        System.out.println("True Record (After):     " + person.grades()); // State has NOT changed
    }
}

/**
 * A FAILED attempt at an immutable class. It is mutable because it allows
 * "reference escape" of its internal list.
 */
final class FlawedImmutableStudent {
    private final String name;
    private final List<Integer> marks;

    public FlawedImmutableStudent(String name, List<Integer> marks) {
        // FLAW: Stores a direct reference to the external list.
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public List<Integer> getMarks() {
        // FLAW: Returns a direct reference to the internal list.
        return marks;
    }
}

/**
 * A truly immutable class using a record (Java 16+).
 * This is the modern best practice for immutable data carriers.
 */
record TrulyImmutablePerson(String name, List<Integer> grades) {
    /**
     * Compact constructor performs a defensive copy on incoming data,
     * ensuring the internal state is protected.
     */
    public TrulyImmutablePerson {
        // Defensive copy makes the internal list unmodifiable.
        grades = List.copyOf(grades);
    }
}
