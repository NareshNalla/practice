package com.naresh.a_dsalgo.ab_strings.problems;

public class SentenceSimilarityIII {
    public static void main(String[] args) {
        var sol = new SentenceSimilarityIII();
        System.out.println("Similar: " + sol.areSentenceSimilar3("My name is Haley", "My Haley")); // true
        System.out.println("Similar: " + sol.areSentenceSimilar3("of", "A lot of words")); // true
        System.out.println("Similar: " + sol.areSentenceSimilar3("Eating right now", "Eating")); // true
        System.out.println("Similar: " + sol.areSentenceSimilar3("Luo", "HeLuo")); // false

        System.out.println("Similar: areSentenceSimilar3i " + sol.areSentenceSimilar3i("Eating right now", "Eating")); // true
    }

    /**
     * Algorithm: Split sentences into word arrays. Use two pointers from both ends. 
     * Match from left as long as words are equal, then match from right. 
     * The shorter sentence must be fully consumed by the prefix and suffix matching, 
     * meaning any middle gap in the longer sentence is where the 'arbitrary sentence' was inserted.
     */
    public boolean areSentenceSimilar3(String s1, String s2) {
        // Pattern: Two-Pointer / Deque Logic | Time: O(N + M), Space: O(N + M)
        if (s1 == null || s2 == null) return false;
        String[] w1 = s1.split(" "), w2 = s2.split(" ");
        int n1 = w1.length, n2 = w2.length;
        if (n1 > n2) return areSentenceSimilar3(s2, s1);

        int l = 0, r = 0;
        // Match prefix
        while (l < n1 && w1[l].equals(w2[l]))
            l++;
        // Match suffix
        while (r < n1 - l && w1[n1 - 1 - r].equals(w2[n2 - 1 - r]))
            r++;
        
        return l + r == n1;
    }
    /* Time: O(N+M) Space: O(1) */
    public boolean areSentenceSimilar3i(String s1, String s2) {
        String[] w1 = s1.split(" ");
        String[] w2 = s2.split(" ");

        // Ensure w1 is the shorter (or equal) sentence
        if (w1.length > w2.length) { String[] tmp = w1; w1 = w2; w2 = tmp; }

        int l = 0, r1 = w1.length - 1, r2 = w2.length - 1;

        // Match from left
        while (l <= r1 && w1[l].equals(w2[l])) l++;

        // Match from right
        while (r1 >= l && w1[r1].equals(w2[r2])) { r1--; r2--; }

        // Shorter sentence must be fully consumed
        return l > r1;
    }
}
