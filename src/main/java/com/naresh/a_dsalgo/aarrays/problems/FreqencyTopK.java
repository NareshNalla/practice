package com.naresh.a_dsalgo.aarrays.problems;

import java.util.*;
import java.util.stream.Collectors;

public class FreqencyTopK {

    public static int[] topKFrequent(int[] nums, int k) {
        // Pattern: Bucket Sort | Time: O(n), Space: O(n)
        if (nums == null || nums.length == 0) return new int[0];
        var map = new HashMap<Integer, Integer>();
        for (int x : nums)
            map.merge(x, 1, Integer::sum);
        var buckets = new List[nums.length + 1];
        map.forEach((v, f) -> {
            if (buckets[f] == null) buckets[f] = new ArrayList<Integer>();
            buckets[f].add(v);
        });
        var res = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] == null) continue;
            for (var v : (List<Integer>) buckets[i])
                if (idx < k) res[idx++] = v;
        }
        return res;
    }

    public static int[] topKFrequentStream(int[] nums, int k) {
        // Pattern: Hashing & Stream Sort | Time: O(n log u), Space: O(u)
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
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
        var pq = new PriorityQueue<Integer>(Comparator.comparingInt(map::get));
        for (int x : map.keySet()) {
            pq.add(x);
            if (pq.size() > k) pq.poll();
        }
        var res = new int[k];
        for (int i = k - 1; i >= 0; i--)
            res[i] = pq.poll();
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3};
        System.out.println("Bucket: " + Arrays.toString(topKFrequent(nums, 2)));
        System.out.println("Stream: " + Arrays.toString(topKFrequentStream(nums, 2)));
        System.out.println("Heap:   " + Arrays.toString(topKFrequentHeap(nums, 2)));
    }
}
