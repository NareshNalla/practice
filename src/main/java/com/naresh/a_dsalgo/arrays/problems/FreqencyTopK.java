package com.naresh.a_dsalgo.arrays.problems;

import java.util.*;

public class FreqencyTopK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3};
        System.out.println("Bucket Sort: " + Arrays.toString(topKFrequent(nums, 2)));
        System.out.println("Stream Sort: " + Arrays.toString(topKFrequentStream(nums, 2)));
        System.out.println("Heap:        " + Arrays.toString(topKFrequentHeap(nums, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // Pattern: Bucket Sort | Time: O(n), Space: O(n)
        if (nums == null || nums.length == 0) return new int[0];
        var counts = new HashMap<Integer, Integer>();
        for (int x : nums)
            counts.merge(x, 1, Integer::sum);

        var buckets = new List[nums.length + 1];
        counts.forEach((val, freq) -> {
            if (buckets[freq] == null) buckets[freq] = new ArrayList<Integer>();
            buckets[freq].add(val);
        });

        var res = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] == null) continue;
            for (int val : (List<Integer>) buckets[i])
                if (idx < k) res[idx++] = val;
        }
        return res;
    }

    public static int[] topKFrequentStream(int[] nums, int k) {
        // Pattern: Hashing & Stream Sort | Time: O(n log u), Space: O(u)
        if (nums == null || nums.length == 0) return new int[0];
        var map = new HashMap<Integer, Integer>();
        for (int x : nums)
            map.merge(x, 1, Integer::sum);

        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public static int[] topKFrequentHeap(int[] nums, int k) {
        // Pattern: Min-Heap | Time: O(n log k), Space: O(u)
        if (nums == null || nums.length == 0) return new int[0];
        var map = new HashMap<Integer, Integer>();
        for (int x : nums)
            map.merge(x, 1, Integer::sum);

        var heap = new PriorityQueue<Integer>(Comparator.comparingInt(map::get));
        for (int x : map.keySet()) {
            heap.add(x);
            if (heap.size() > k) heap.poll();
        }

        var res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = heap.poll();
        return res;
    }
}
