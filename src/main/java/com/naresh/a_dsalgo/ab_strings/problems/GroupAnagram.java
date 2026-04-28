package com.naresh.a_dsalgo.ab_strings.problems;

import java.util.*;

/**
 * Problem: Group Anagrams
 * Description: Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class GroupAnagram {
    public static void main(String[] args) {
        var ga = new GroupAnagram();
        System.out.println(ga.groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"}));
        System.out.println(ga.groupAnagrams(new String[]{"x"}));
        System.out.println(ga.groupAnagrams(new String[]{""}));
    }

    /**
     * Algorithm: Use a hash map where the key is a frequency array (or sorted string) of characters for each word,
     * and the value is a list of strings that share that frequency pattern (i.e., are anagrams).
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // Pattern: Hashing with Frequency Array | Time: O(n * k), Space: O(n * k)
        if (strs == null || strs.length == 0) return new ArrayList<>();
        var map = new HashMap<String, List<String>>(); // Key: frequency array string, Value: list of anagrams
        for (String s : strs) {
            int[] counts = new int[256]; // Assuming ASCII characters
            for (char c : s.toCharArray()) counts[c]++; // Build frequency count for current string
            var key = Arrays.toString(counts); // Convert frequency array to a string key
            map.computeIfAbsent(key, k -> new ArrayList<>()) // Get list for key, or create if absent
                    .add(s); // Add current string to the list
        }
        return new ArrayList<>(map.values()); // Return all grouped anagrams
    }
    // FAANG Tip: Using a frequency array as a key is generally faster than sorting the string for each word, especially for longer strings.
}

/**
 * Dry Run:
 * Input: strs = {"act", "pots", "tops", "cat", "stop", "hat"}
 *
 * 1. Initialization:
 *    map = {}
 *
 * 2. Iteration for "act":
 *    - s = "act"
 *    - counts = [0, ..., a:1, c:1, t:1, ..., 0]
 *    - key = "[0, 0, ..., 1, 0, 1, ..., 1, ..., 0]" (string representation of counts array)
 *    - map.computeIfAbsent(key, ...) -> creates new ArrayList
 *    - map.get(key).add("act")
 *    - map = { "[...a:1,c:1,t:1...]": ["act"] }
 *
 * 3. Iteration for "pots":
 *    - s = "pots"
 *    - counts = [0, ..., o:1, p:1, s:1, t:1, ..., 0]
 *    - key = "[...o:1,p:1,s:1,t:1...]"
 *    - map.computeIfAbsent(key, ...) -> creates new ArrayList
 *    - map.get(key).add("pots")
 *    - map = {
 *        "[...a:1,c:1,t:1...]": ["act"],
 *        "[...o:1,p:1,s:1,t:1...]": ["pots"]
 *      }
 *
 * 4. Iteration for "tops":
 *    - s = "tops"
 *    - counts = [0, ..., o:1, p:1, s:1, t:1, ..., 0] (same as "pots")
 *    - key = "[...o:1,p:1,s:1,t:1...]"
 *    - map.computeIfAbsent(key, ...) -> finds existing ArrayList for this key
 *    - map.get(key).add("tops")
 *    - map = {
 *        "[...a:1,c:1,t:1...]": ["act"],
 *        "[...o:1,p:1,s:1,t:1...]": ["pots", "tops"]
 *      }
 *
 * 5. Iteration for "cat":
 *    - s = "cat"
 *    - counts = [0, ..., a:1, c:1, t:1, ..., 0] (same as "act")
 *    - key = "[...a:1,c:1,t:1...]"
 *    - map.computeIfAbsent(key, ...) -> finds existing ArrayList for this key
 *    - map.get(key).add("cat")
 *    - map = {
 *        "[...a:1,c:1,t:1...]": ["act", "cat"],
 *        "[...o:1,p:1,s:1,t:1...]": ["pots", "tops"]
 *      }
 *
 * 6. Iteration for "stop":
 *    - s = "stop"
 *    - counts = [0, ..., o:1, p:1, s:1, t:1, ..., 0] (same as "pots", "tops")
 *    - key = "[...o:1,p:1,s:1,t:1...]"
 *    - map.computeIfAbsent(key, ...) -> finds existing ArrayList for this key
 *    - map.get(key).add("stop")
 *    - map = {
 *        "[...a:1,c:1,t:1...]": ["act", "cat"],
 *        "[...o:1,p:1,s:1,t:1...]": ["pots", "tops", "stop"]
 *      }
 *
 * 7. Iteration for "hat":
 *    - s = "hat"
 *    - counts = [0, ..., a:1, h:1, t:1, ..., 0]
 *    - key = "[...a:1,h:1,t:1...]"
 *    - map.computeIfAbsent(key, ...) -> creates new ArrayList
 *    - map.get(key).add("hat")
 *    - map = {
 *        "[...a:1,c:1,t:1...]": ["act", "cat"],
 *        "[...o:1,p:1,s:1,t:1...]": ["pots", "tops", "stop"],
 *        "[...a:1,h:1,t:1...]": ["hat"]
 *      }
 *
 * 8. Final Result:
 *    new ArrayList<>(map.values()) returns a list of lists, e.g.,
 *    [
 *      ["act", "cat"],
 *      ["pots", "tops", "stop"],
 *      ["hat"]
 *    ]
 */
