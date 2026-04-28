package com.naresh.a_dsalgo.ab_strings.problems;

import java.util.*;

/**
 * Problem: Sentence Similarity III (LeetCode 1813)
 * Description: A sentence is similar to another sentence if you can insert an arbitrary sentence 
 * (possibly empty) into the middle of the first sentence to make it equal to the second sentence.
 */
public class SentenceSimilarityIII {
    /**
     * Algorithm: Use two pointers (left and right) to find the longest common prefix and suffix. 
     * If the remaining parts of s1 or s2 can be fully consumed by the other, they are similar.
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // Pattern: Two Pointers | Time: O(N + M), Space: O(N + M) for split
        var words1 = sentence1.split(" ");
        var words2 = sentence2.split(" ");

        int i = 0, j = 0; // Pointers for words1 and words2
        int n1 = words1.length, n2 = words2.length;

        // Consume common prefix
        while (i < n1 && i < n2 && words1[i].equals(words2[i])) {
            i++;
        }

        // Consume common suffix
        while (j < n1 - i && j < n2 - i && words1[n1 - 1 - j].equals(words2[n2 - 1 - j])) {
            j++;
        }

        // Check if one sentence can be formed by inserting into the other
        // This means either all of words1 is consumed (i + j == n1) or all of words2 is consumed (i + j == n2)
        return (i + j == n1) || (i + j == n2);
    }
    // FAANG Tip: This problem is about finding common prefix and suffix. The "insertion" implies one sentence is a subsequence of the other, with a contiguous block inserted.

    public static void main(String[] args) {
        var sol = new SentenceSimilarityIII();
        System.out.println(sol.areSentencesSimilar("My name is Haley", "My name is John Haley")); // Expected: true
        System.out.println(sol.areSentencesSimilar("of", "A lot of words")); // Expected: false
        System.out.println(sol.areSentencesSimilar("Eating right now", "Eating")); // Expected: true
        System.out.println(sol.areSentencesSimilar("Eating", "Eating right now")); // Expected: true
        System.out.println(sol.areSentencesSimilar("a", "b")); // Expected: false
        System.out.println(sol.areSentencesSimilar("a", "a")); // Expected: true
        System.out.println(sol.areSentencesSimilar("abcd", "abcccd")); // Expected: true
    }
}

/**
 * Dry Run:
 * Input: sentence1 = "My name is Haley", sentence2 = "My name is John Haley"
 *
 * 1. Initialization:
 *    words1 = ["My", "name", "is", "Haley"], n1 = 4
 *    words2 = ["My", "name", "is", "John", "Haley"], n2 = 5
 *    i = 0, j = 0
 *
 * 2. Consume Common Prefix:
 *    - i=0: words1[0]="My", words2[0]="My". Match. i becomes 1.
 *    - i=1: words1[1]="name", words2[1]="name". Match. i becomes 2.
 *    - i=2: words1[2]="is", words2[2]="is". Match. i becomes 3.
 *    - i=3: words1[3]="Haley", words2[3]="John". No match. Loop ends.
 *    - Current state: i = 3, j = 0
 *
 * 3. Consume Common Suffix:
 *    - j=0: words1[n1-1-j] (words1[3])="Haley", words2[n2-1-j] (words2[4])="Haley". Match. j becomes 1.
 *    - j=1: n1-i-j (4-3-1=0) is not < n1-i (4-3=1). Loop condition (j < n1-i) fails. Loop ends.
 *    - Current state: i = 3, j = 1
 *
 * 4. Check Similarity Condition:
 *    - (i + j == n1) OR (i + j == n2)
 *    - (3 + 1 == 4) OR (3 + 1 == 5)
 *    - (4 == 4) OR (4 == 5)
 *    - true OR false -> true
 *
 * 5. Result: true
 */
