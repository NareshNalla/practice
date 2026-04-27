package com.naresh.a_dsalgo.ab_strings.problems;

import java.util.*;

public class SentenceSimilarity {
    public static void main(String[] args) {
        var sol = new SentenceSimilarity();
        String[] s1 = {"great", "acting", "skills"}, s2 = {"good", "drama", "talent"};
        var pairs = List.of(List.of("great", "fine"), List.of("fine", "good"), List.of("acting", "drama"), List.of("skills", "talent"));
        
        System.out.println("Basic Similarity: " + sol.areSentencesSimilar(s1, s2, pairs));
        System.out.println("Transitive (DFS): " + sol.areSentencesSimilarTransitive(s1, s2, pairs));
    }

    /*
     * Algorithm: Build a HashSet of 'word1#word2' from all pairs (store ONE direction).
     * At lookup, check BOTH directions — saves O(P) space vs storing twice.
     * Then zip-check both sentences word by word.
     */
    public boolean areSentencesSimilar(String[] s1, String[] s2, List<List<String>> pairs) {
        // Pattern: HashSet Lookup | Time: O(N + P), Space: O(P)
        if (s1 == null || s2 == null || s1.length != s2.length) return false;
        var pairSet = new HashSet<String>();
        for (var p : pairs)
            pairSet.add(p.get(0) + "#" + p.get(1));
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].equals(s2[i])) continue;
            if (!pairSet.contains(s1[i] + "#" + s2[i]) && !pairSet.contains(s2[i] + "#" + s1[i])) return false;
        }
        return true;
    }

    public boolean areSentencesSimilarTransitive(String[] s1, String[] s2, List<List<String>> pairs) {
        // Pattern: Graph DFS | Time: O(N * (V + E)), Space: O(V + E)
        if (s1 == null || s2 == null || s1.length != s2.length) return false;
        var adj = new HashMap<String, Set<String>>();
        for (var p : pairs) {
            adj.computeIfAbsent(p.get(0), k -> new HashSet<>()).add(p.get(1));
            adj.computeIfAbsent(p.get(1), k -> new HashSet<>()).add(p.get(0));
        }
        for (int i = 0; i < s1.length; i++)
            if (!canReach(s1[i], s2[i], adj, new HashSet<>())) return false;
        return true;
    }

    private boolean canReach(String curr, String target, Map<String, Set<String>> adj, Set<String> visited) {
        // Pattern: DFS Traversal | Time: O(V + E), Space: O(V)
        if (curr.equals(target)) return true;
        visited.add(curr);
        for (var next : adj.getOrDefault(curr, Set.of()))
            if (!visited.contains(next) && canReach(next, target, adj, visited)) return true;
        return false;
    }
}
