package com.naresh.a_dsalgo.strings.problems;

public class RemoveSpacesOptimized {

    /**
     * without using replaceAll().
     *
     * Time Complexity: O(n) Space Complexity: O(n) -
     * Interview Takeaway: Always prefer Character.isWhitespace(c) over a manual
     * check like `c != ' '`. The library method is more robust as it correctly
     * handles all forms of whitespace (spaces, tabs, newlines, etc.).
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
