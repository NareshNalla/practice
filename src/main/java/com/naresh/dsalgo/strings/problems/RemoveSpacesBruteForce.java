package com.naresh.dsalgo.strings.problems;

public class RemoveSpacesBruteForce {

    /**
     * The most common and practical real-world solution to remove all whitespace
     * from a string in Java, using the built-in `replaceAll` method.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static String removeSpaces(String input) {
        if (input == null) {
            return null;
        }
        // The regex "\\s" matches all whitespace characters (spaces, tabs, newlines, etc.).
        return input.replaceAll("\\s", "");
    }

    public static void main(String[] args) {
        String testString = "g      eeks for \t ge eeks \n";
        String result = removeSpaces(testString);
        System.out.println(result); // Expected output: geeksforgeeeks
    }
}
