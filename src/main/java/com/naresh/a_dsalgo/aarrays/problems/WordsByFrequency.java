package com.naresh.a_dsalgo.aarrays.problems;

import java.util.*;
import java.util.stream.Collectors;

public class WordsByFrequency {

    /**
     * Modern Approach: Hashing & Stream Sort
     * Time Complexity: O(U log U) - where U is the number of unique words
     * Space Complexity: O(U)
     */
    public static List<String> sortByFrequencyStream(String[] words) {
        if (words == null || words.length == 0) return Collections.emptyList();

        return Arrays.stream(words)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * Optimal Interview Approach: Bucket Sort
     * Time Complexity: O(N) - N is total words
     * Space Complexity: O(N)
     */
    public static List<String> sortByFrequencyBucket(String[] words) {
        if (words == null || words.length == 0) return Collections.emptyList();

        // 1. Map frequencies
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }

        // 2. Create buckets where index = frequency
        List<String>[] buckets = new List[words.length + 1];
        for (String key : map.keySet()) {
            int frequency = map.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        // 3. Collect words from end of buckets (highest frequency first)
        List<String> res = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                res.addAll(buckets[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "abc", "abc", "xyz", "xyz", "axy", "pqr"};
        
        System.out.println("Input: " + Arrays.toString(words));
        System.out.println("Stream Result: " + sortByFrequencyStream(words));
        System.out.println("Bucket Result: " + sortByFrequencyBucket(words));
    }
}
