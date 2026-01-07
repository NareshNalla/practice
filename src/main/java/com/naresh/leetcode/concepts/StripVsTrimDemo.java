package com.naresh.leetcode.concepts;

/**
 * Demonstrates the critical difference between the modern `strip()` method (Java 11+)
 * and the legacy `trim()` method for removing whitespace.
 */
public class StripVsTrimDemo {

    public static void main(String[] args) {
        // \u2003 is an "em space", a common Unicode whitespace character that trim() does not recognize.
        String stringWithUnicodeSpace = "\u2003  Hello World  \u2003";

        System.out.println("Original String: '" + stringWithUnicodeSpace + "'");
        System.out.println("-------------------------------------------------");

        // Using the old trim() method
        String trimmed = stringWithUnicodeSpace.trim();
        System.out.println("Using trim(): '" + trimmed + "'");
        System.out.println("==> FLAW: The Unicode space was NOT removed.");

        System.out.println();

        // Using the new strip() method
        String stripped = stringWithUnicodeSpace.strip();
        System.out.println("Using strip(): '" + stripped + "'");
        System.out.println("==> SUCCESS: All leading and trailing whitespace was removed.");
    }
}
