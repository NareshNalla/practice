package com.naresh.b_concepts.immutable;

public class StringImmutabilityTest {
    public static void main(String[] args) {
        String s = "Hello  ";
        s += "Adobe . ";
        s.trim();
        System.out.print(s);
    }
}
//output: Hello  Adobe .
