package com.naresh.a_dsalgo.arrays.problems;

import java.util.*;

public class SortbyFrequencyIncreasing {
    public static void main(String[] args) {
        int[] array = {4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5};
        sortByFrequency(array);
        System.out.println("\n---");
        sortByFrequencyOptimized(array);
    }

    public static void sortByFrequency(int[] nums) {
        // Pattern: Frequency Hashing & Custom Sort | Time: O(n log n), Space: O(n)
        if (nums == null || nums.length == 0) return;
        var map = new HashMap<Integer, Integer>();
        for (int x : nums)
            map.merge(x, 1, Integer::sum);
        //
        var list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        list.sort(Comparator.comparingInt(map::get).thenComparingInt(a -> (int) a));

        System.out.println("list: "+list + " ");
        for (int x : list)
            System.out.print(x + " ");
    }

    public static void sortByFrequencyOptimized(int[] nums) {
        // Pattern: Bucket Sort | Time: O(n), Space: O(n)
        if (nums == null || nums.length == 0) return;
        var map = new HashMap<Integer, Integer>();
        for (int x : nums)
            map.merge(x, 1, Integer::sum);

        System.out.print("Most repeated first two values: ");
        map.entrySet()
           .stream()
           .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
           .limit(2)
           .forEach(entry -> System.out.print(entry.getKey() + " (freq: " + entry.getValue() + ") "));

        //int[] arr = list.stream().mapToInt( i-> (int)i).toArray();
        System.out.println("\nFull bucket sort:");
        var buckets = new List[nums.length + 1];
        map.forEach((v, f) -> {
            if (buckets[f] == null) buckets[f] = new ArrayList<Integer>();
            buckets[f].add(v);
        });

        for (int f = 1; f < buckets.length; f++) {
            if (buckets[f] == null) continue;
            Collections.sort(buckets[f]);
            for (var v : buckets[f])
                System.out.print((v + " ").repeat(f));
        }
    }
}

/**
 * NOTE: To sort by DECREASING frequency:
 * 1. In sortByFrequency: Change to .sort(Comparator.comparingInt(map::get).reversed().thenComparingInt(a -> a))
 * 2. In sortByFrequencyOptimized: Iterate buckets backwards from nums.length down to 1.
 */
