package com.naresh.a_dsalgo.astrings.problems;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        var ga = new GroupAnagram();
        System.out.println(ga.groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"}));
        System.out.println(ga.groupAnagrams(new String[]{"x"}));
        System.out.println(ga.groupAnagrams(new String[]{""}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // Pattern: Hashing with Frequency Array | Time: O(n * k), Space: O(n * k)
        if (strs == null || strs.length == 0) return new ArrayList<>();
        var map = new HashMap<String, List<String>>();
        for (String s : strs) {
            int[] counts = new int[256];
            for (char c : s.toCharArray()) counts[c]++;
            var key = Arrays.toString(counts);
            map.computeIfAbsent(key, k -> new ArrayList<>())
                    .add(s);
        }
        return new ArrayList<>(map.values());
    }
}
