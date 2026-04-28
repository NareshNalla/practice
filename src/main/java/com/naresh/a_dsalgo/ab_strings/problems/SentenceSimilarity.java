package com.naresh.a_dsalgo.ab_strings.problems;

import java.util.*;

/**
 * Problem: Sentence Similarity (LeetCode 734)
 * Description: Two sentences are similar if they have the same length and for every word in s1, 
 * the corresponding word in s2 is either the same or they form a similarity pair. 
 * Similarity is NOT transitive.
 */
public class SentenceSimilarity {
    /**
     * Algorithm: Use a HashSet of "word1#word2" for O(1) lookups. For each word pair (w1, w2), 
     * check if w1 == w2 OR if (w1, w2) or (w2, w1) exists in the set.
     */
    public boolean areSentencesSimilar(String[] s1, String[] s2, List<List<String>> pairs) {
        // Pattern: HashSet Lookup | Time: O(N + P), Space: O(P)
        if (s1.length != s2.length) return false;
        var set = new HashSet<String>();
        for (var pair : pairs) set.add(pair.get(0) + "#" + pair.get(1));
        
        for (int i = 0; i < s1.length; i++) {
            var w1 = s1[i]; var w2 = s2[i];
            if (w1.equals(w2)) continue;
            if (!set.contains(w1 + "#" + w2) && !set.contains(w2 + "#" + w1)) return false;
        }
        return true;
    }
    // FAANG Tip: Since similarity is not transitive, a simple HashSet is sufficient. Always verify if the relation is symmetric (a~b => b~a).

    public static void main(String[] args) {
        var sol = new SentenceSimilarity();
        String[] s1 = {"great", "acting", "skills"}, s2 = {"fine", "drama", "talent"};
        var pairs = List.of(List.of("great", "fine"), List.of("acting", "drama"), List.of("skills", "talent"));
        System.out.println(sol.areSentencesSimilar(s1, s2, pairs)); // Expected: true
    }
}

/**
 * Dry Run:
 * Input: s1=["great", "acting"], s2=["fine", "drama"], pairs=[["great", "fine"], ["acting", "drama"]]
 *
 * 1. Build Set:
 *    set = {"great#fine", "acting#drama"}
 *
 * 2. Iteration i=0:
 *    w1="great", w2="fine"
 *    w1 != w2. Check set for "great#fine" or "fine#great" -> Found "great#fine". Continue.
 *
 * 3. Iteration i=1:
 *    w1="acting", w2="drama"
 *    w1 != w2. Check set for "acting#drama" or "drama#acting" -> Found "acting#drama". Continue.
 *
 * 4. Result: true
 */
