package com.naresh.b_concepts.immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates the difference between a flawed and a correct immutable class in Java.
 */
public class ImmutabilityBestPractices {

    public static void main(String[] args) {
        // 1. Flawed "Immutable" Class Demonstration
        List<Integer> marksList = new ArrayList<>(Arrays.asList(90, 85, 88));
        MutableStudent mutableStudent = new MutableStudent("Alex", marksList);
        System.out.println("Mutable Student (Before): " + mutableStudent.getMarks());

        marksList.add(70);         // External list modification
        mutableStudent.getMarks().set(0, 50); // Getter modification

        System.out.println("Mutable Student (After):  " + mutableStudent.getMarks()); // State has changed

        // 2. Truly Immutable Record Demonstration
        List<Integer> gradesList = new ArrayList<>(Arrays.asList(90, 85, 88));
        ImmutableStudent immutablePerson = new ImmutableStudent("Maria", gradesList);
        System.out.println("Immutable Person (Before):    " + immutablePerson.grades());

        gradesList.add(70); // Attempt to modify via original list
        try {
            immutablePerson.grades().add(50); // Attempt to modify via accessor
        } catch (UnsupportedOperationException e) {
            // Expected: The list returned by the record is unmodifiable.
            System.err.println("add() UnsupportedOperationException - immutable list/;0"+e);
        }

        // Demonstrate that set(index, value) is also unsupported on the immutable list
        try {
            immutablePerson.grades().set(0, 50); // Attempt to modify via set
        } catch (UnsupportedOperationException e) {
            System.err.println("set() UnsupportedOperationException - immutable list "+e);
        }

        System.out.println("Immutable Person (After):     " + immutablePerson.grades()); // State has NOT changed
    }
}

/**
 * A FAILED attempt at an immutable class. It is mutable because it allows
 * "reference escape" of its internal list.
 */
final class MutableStudent {
    private final String name;
    private final List<Integer> marks;

    public MutableStudent(String name, List<Integer> marks) {
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
record ImmutableStudent(String name, List<Integer> grades) {
    /**
     * Compact constructor performs a defensive copy on incoming data,
     * ensuring the internal state is protected.
     */
    public ImmutableStudent {

        grades = List.copyOf(grades); // SHALLOW UNMODIFIABLE COPY (prevents external mutation)
        //grades = new ArrayList<>(grades); // SHALLOW MUTABLE COPY (protects original reference but remains modifiable)345
    }
}
