package com.naresh.a_dsalgo.ab_strings.problems;

import java.util.*;

/**
 * Problem: Sentence Similarity II (LeetCode 737)
 * Description: Two sentences are similar if they have the same length and every word at the same index is similar. 
 * Similarity is transitive (a~b, b~c => a~c).
 */
public class SentenceSimilarityII {
    /**
     * Algorithm: Use Union-Find to handle transitivity. Group similar words into components. 
     * Two words are similar if they belong to the same disjoint set (root).
     */
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        // Pattern: Union-Find (DSU) | Time: O(P*α(V) + N*α(V)), Space: O(V)
        if (sentence1.length != sentence2.length) return false;
        var parent = new HashMap<String, String>();
        
        for (var pair : similarPairs) {
            union(pair.get(0), pair.get(1), parent);
        }

        for (int i = 0; i < sentence1.length; i++) {
            var w1 = sentence1[i]; var w2 = sentence2[i];
            if (w1.equals(w2)) continue;
            if (!find(w1, parent).equals(find(w2, parent))) return false;
        }
        return true;
    }
    // FAANG Tip: Union-Find with path compression is superior to DFS for repeated "connectedness" queries.

    private String find(String i, Map<String, String> parent) {
        if (!parent.containsKey(i)) parent.put(i, i);
        if (parent.get(i).equals(i)) return i;
        parent.put(i, find(parent.get(i), parent)); // Path compression
        return parent.get(i);
    }

    private void union(String i, String j, Map<String, String> parent) {
        var rootI = find(i, parent);
        var rootJ = find(j, parent);
        if (!rootI.equals(rootJ)) parent.put(rootI, rootJ);
    }

    public static void main(String[] args) {
        var sol = new SentenceSimilarityII();
        String[] s1 = {"great", "acting", "skills"}, s2 = {"good", "drama", "talent"};
        var pairs = List.of(List.of("great", "fine"), List.of("fine", "good"), List.of("acting", "drama"), List.of("skills", "talent"));
        System.out.println(sol.areSentencesSimilarTwo(s1, s2, pairs)); // Expected: true
    }
}

/**
 * Dry Run:
 * Input: s1=["great"], s2=["good"], pairs=[["great", "fine"], ["fine", "good"]]
 *
 * 1. Union("great", "fine"):
 *    find("great") -> "great", find("fine") -> "fine". parent = {great: fine, fine: fine}
 *
 * 2. Union("fine", "good"):
 *    find("fine") -> "fine", find("good") -> "good". parent = {great: fine, fine: good, good: good}
 *
 * 3. Check similarity("great", "good"):
 *    find("great") -> fine -> good. (Returns "good" with path compression)
 *    find("good") -> "good".
 *    "good" == "good" -> True.
 *
 * 4. Result: true
 */
