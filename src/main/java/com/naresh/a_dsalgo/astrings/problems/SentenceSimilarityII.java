package com.naresh.a_dsalgo.astrings.problems;

import java.util.*;

public class SentenceSimilarityII {
    public static void main(String[] args) {
        var sol = new SentenceSimilarityII();
        String[] s1 = {"great", "acting", "skills"}, s2 = {"fine", "drama", "talent"};
        var pairs = List.of(List.of("great", "fine"), List.of("fine", "good"), List.of("acting", "drama"), List.of("skills", "talent"));
        System.out.println("Similar (DFS): " + sol.areSentencesSimilarDFS(s1, s2, pairs));
        System.out.println("Similar (UF):  " + sol.areSentencesSimilarUF(s1, s2, pairs));
    }

    public boolean areSentencesSimilarDFS(String[] s1, String[] s2, List<List<String>> pairs) {
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
        if (curr.equals(target)) return true;
        visited.add(curr);
        for (var next : adj.getOrDefault(curr, Set.of()))
            if (!visited.contains(next) && canReach(next, target, adj, visited)) return true;
        return false;
    }

    /**
     * Algorithm: Use a Disjoint Set Union (DSU) to group similar words into connected components.
     * For each pair in the sentences, they are similar if they belong to the same component (same root).
     */
    public boolean areSentencesSimilarUF(String[] s1, String[] s2, List<List<String>> pairs) {
        // Pattern: Union-Find (DSU) | Time: O(P * α(V) + N * α(V)), Space: O(V)
        if (s1 == null || s2 == null || s1.length != s2.length) return false;
        var dsu = new DSU();
        for (var p : pairs)
            dsu.union(p.get(0), p.get(1));
        for (int i = 0; i < s1.length; i++) {
            String w1 = s1[i], w2 = s2[i];
            if (w1.equals(w2)) continue;
            if (!dsu.find(w1).equals(dsu.find(w2))) return false;
        }
        return true;
    }
}

// DisjointSetUnion_UnionFInd
class DSU {
    Map<String, String> parent = new HashMap<>();

    // 1. find — who is the root/representative of this element?
    String find(String x) {
        parent.putIfAbsent(x, x);
        if (!parent.get(x).equals(x))
            parent.put(x, find(parent.get(x))); // path compression
        return parent.get(x);
    }

    // 2. union — merge two groups together
    void union(String a, String b) {
        String r1 = find(a), r2 = find(b);
        if (!r1.equals(r2)) parent.put(r1, r2);
    }

    // 3. connected — are they in the same group?
    boolean connected(String a, String b) {
        return find(a).equals(find(b));
    }
}
