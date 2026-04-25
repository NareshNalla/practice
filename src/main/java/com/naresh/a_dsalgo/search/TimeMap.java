package com.naresh.a_dsalgo.search;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Problem: Time Based Key-Value Store
 * Description: Design a time-based key-value data structure that can store multiple values 
 * for the same key at different time stamps and retrieve the key's value at a certain timestamp.
 * 
 * FAANG Pattern: "Binary Search on Timestamps (Floor Logic)"
 * Strategy:
 * 1. Use a HashMap where the key is the String key and the value is a collection of (timestamp, value) pairs.
 * 2. Since timestamps are strictly increasing in 'set', the collection is sorted.
 * 3. Use binary search (or TreeMap.floorEntry) to find the largest timestamp <= requested timestamp.
 * 
 * Time Complexity:
 * - set: O(log n) if using TreeMap, or O(1) if using ArrayList (since timestamps are increasing).
 * - get: O(log n)
 * Space Complexity: O(n) where n is number of set calls.
 */
public class TimeMap {
    // Map from key to a TreeMap of [timestamp -> value]
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    /**
     * Stores the key with the value at the given timestamp.
     */
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    /**
     * Returns a value such that set was called previously, with timestamp_prev <= timestamp.
     * If there are multiple such values, it returns the value associated with the largest timestamp_prev.
     * If there are no values, it returns "".
     */
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) {
            return "";
        }
        
        // floorEntry(k) returns the entry with the greatest key <= k
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        
        System.out.println("--- TimeMap Validation ---");
        
        timeMap.set("foo", "bar", 1);
        System.out.println("get foo @ 1 (Expected bar): " + timeMap.get("foo", 1));
        System.out.println("get foo @ 3 (Expected bar): " + timeMap.get("foo", 3));
        
        timeMap.set("foo", "bar2", 4);
        System.out.println("get foo @ 4 (Expected bar2): " + timeMap.get("foo", 4));
        System.out.println("get foo @ 5 (Expected bar2): " + timeMap.get("foo", 5));
        
        System.out.println("get foo @ 0 (Expected \"\"): " + timeMap.get("foo", 0));
    }
}
