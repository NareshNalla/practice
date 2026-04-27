package com.naresh.a_dsalgo.ab_strings.problems;

public class RemoveSpaces {
    public static void main(String[] args) {
        String s = "g      eeks for \t ge eeks \n";
        System.out.println("Regex: " + removeSpacesRegex(s));
        System.out.println("Iterative: " + removeSpacesIterative(s));
    }

    public static String removeSpacesRegex(String s) {
        // Pattern: Built-in Regex | Time: O(n), Space: O(n)
        return s == null ? null : s.replaceAll("\\s", "");
    }

    public static String removeSpacesIterative(String s) {
        // Pattern: String Building | Time: O(n), Space: O(n)
        if (s == null) return null;
        var sb = new StringBuilder();
        for (char c : s.toCharArray())
            if (!Character.isWhitespace(c)) sb.append(c);
        return sb.toString();
    }
}
