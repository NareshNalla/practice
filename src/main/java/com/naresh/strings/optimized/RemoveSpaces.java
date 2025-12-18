package com.naresh.strings.optimized;

public class RemoveSpaces {

    /**
     * Removes all whitespace from a string without using replaceAll().
     * This is the optimal solution in Java.
     *
     * Time Complexity: O(n) - We must look at every character once.
     * Space Complexity: O(n) - A new string/builder must be created as Java strings are immutable.
     *
     * Interview Takeaway: Always prefer Character.isWhitespace(c) over a manual
     * check like `c != ' '`. The library method is more robust as it correctly
     * handles all forms of whitespace (spaces, tabs, newlines, etc.).
     *
     * @param input The string to remove spaces from.
     * @return A new string with all spaces removed.
     */
    public static String removeSpaces(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String testString = "g      eeks for     ge eeks ";
        String result = removeSpaces(testString);
        System.out.println(result); // Expected output: geeksforgeeeks
    }
}
