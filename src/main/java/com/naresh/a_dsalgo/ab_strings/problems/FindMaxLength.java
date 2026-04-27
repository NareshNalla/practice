package com.naresh.a_dsalgo.ab_strings.problems;

public class FindMaxLength {
    public static void main(String[] args) {
        String s = " happy diwali to all my friends andfamily";
        printMinMaxWord(s);
    }

    public static void printMinMaxWord(String s) {
        // Time: O(n), Space: O(w) where w is max word length
        if (s == null || s.isBlank()) return;
        String[] words = s.trim().split("\\s+");
        String min = words[0], max = words[0];
        for (String w : words) {
            if (w.length() > max.length()) max = w;
            if (w.length() < min.length()) min = w;
        }
        System.out.println("Max: " + max + "\nMin: " + min);
    }
}
