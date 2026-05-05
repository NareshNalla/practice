package com.naresh.a_dsalgo.graphs.problems;

import java.util.*;

/**
 * Problem: Word Ladder
 * Description: Find the length of the shortest transformation sequence from beginWord to endWord using a dictionary.
 */
public class WordLadder {
    /**
     * Algorithm: BFS to find the shortest path in the word graph. 
     * Optimize by changing one character at a time and checking existence in the dictionary.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Pattern: BFS (Shortest Path) | Time: O(N * M^2), Space: O(N * M)
        var dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        
        var q = new ArrayDeque<String>();
        q.offer(beginWord);
        var level = 1;
        
        while (!q.isEmpty()) {
            var size = q.size();
            for (int i = 0; i < size; i++) {
                var curr = q.poll();
                if (curr.equals(endWord)) return level;
                
                var chars = curr.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    var original = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chars[j] = c;
                        var next = String.valueOf(chars);
                        if (dict.contains(next)) {
                            q.offer(next);
                            dict.remove(next); // Mark as visited
                        }
                    }
                    chars[j] = original; // Backtrack
                }
            }
            level++;
        }
        return 0;
    }
    // FAANG Tip: BFS guarantees shortest path. Removing words from the set acts as a 'visited' check.

    public static void main(String[] args) {
        var sol = new WordLadder();

        // Test Case 1: Standard word ladder
        // Begin: "hit", End: "cog"
        // WordList: ["hot","dot","dog","lot","log","cog"]
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int result1 = sol.ladderLength("hit", "cog", wordList1);
        System.out.println("Test Case 1 (hit -> cog): " + (result1 == 5 ? "PASS" : "FAIL"));

        // Test Case 2: End word not in list
        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        int result2 = sol.ladderLength("hit", "cog", wordList2);
        System.out.println("Test Case 2 (End Not Found): " + (result2 == 0 ? "PASS" : "FAIL"));

        // Test Case 3: Single step transformation
        List<String> wordList3 = Arrays.asList("hot");
        int result3 = sol.ladderLength("hit", "hot", wordList3);
        System.out.println("Test Case 3 (One Step): " + (result3 == 2 ? "PASS" : "FAIL"));

        // Test Case 4: No path exists
        List<String> wordList4 = Arrays.asList("dog", "lot", "log", "cog");
        int result4 = sol.ladderLength("hit", "cog", wordList4);
        System.out.println("Test Case 4 (No Path): " + (result4 == 0 ? "PASS" : "FAIL"));
    }
}
