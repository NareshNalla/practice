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
}
