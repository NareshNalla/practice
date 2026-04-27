package com.naresh.a_dsalgo.aa_arrays.problems;

import java.util.*;

/**
 * Problem: Kth Smallest Element in an Array
 * Description: Find the kth smallest element in an unsorted array, treating duplicates as separate elements.
 */
public class KthSmallestSorted {

    /**
     * Algorithm: QuickSelect with random pivot to find the element at the (k-1)th index.
     */
    public int quickSelect(int[] nums, int k) {
        // Pattern: QuickSelect | Time: Avg O(n), Worst O(n^2), Space: O(1)
        if (nums == null || k <= 0 || k > nums.length) return -1;
        return quickSelectHelper(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSelectHelper(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];
        int pivotIndex = left + new Random().nextInt(right - left + 1);
        pivotIndex = partition(nums, left, right, pivotIndex);
        if (k == pivotIndex) return nums[k];
        else if (k < pivotIndex) return quickSelectHelper(nums, left, pivotIndex - 1, k);
        else return quickSelectHelper(nums, pivotIndex + 1, right, k);
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) swap(nums, storeIndex++, i);
        }
        swap(nums, right, storeIndex);
        return storeIndex;
    }

    /**
     * Algorithm: Using TreeMap to store frequencies of each element. Maintains sorted order while respecting duplicates.
     */
    public int kthSmallestTreeMap(int[] in, int k) {
        // Pattern: TreeMap (Frequency Count) | Time: O(n log n), Space: O(n)
        if (in == null || k <= 0 || k > in.length) return Integer.MIN_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int x : in) map.put(x, map.getOrDefault(x, 0) + 1);
        
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if (count >= k) return entry.getKey();
        }
        return Integer.MIN_VALUE;
    }
    // FAANG Tip: TreeMap is used here to maintain sorted order of unique keys while 'Value' stores counts for duplicate handling.

    // --- YOUR ORIGINAL PRACTICE CODE BELOW ---

    public static int kthSmallest2(int[] in, int k) {
        if (k > in.length) return Integer.MIN_VALUE;
        Arrays.sort(in);
        return in[k - 1];
    }

    public static int kthSmallest4(int[] in, int k) {
        if (k > in.length) return Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : in) pq.add(x);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < k; ++i) res = pq.remove();
        return res;
    }

    public static int kthSmallest5(int[] in, int k) {
        if (k > in.length) return Integer.MIN_VALUE;
        int l = 0, r = in.length - 1, p = 0;
        int targetIdx = k - 1; // Convert to 0-based
        while (l <= r) {
            p = partition_medianof3(in, l, r);
            if (targetIdx == p) break;
            if (targetIdx < p) r = p - 1;
            else l = p + 1;
        }
        return in[p];
    }

    private static void swap(int[] in, int i, int j) {
        int tmp = in[i];
        in[i] = in[j];
        in[j] = tmp;
    }

    private static int medianof3(int[] in, int l, int r) {
        if (r - l < 2) return l;
        int mid = l + (r - l) / 2;
        if (in[l] > in[mid]) swap(in, l, mid);
        if (in[l] > in[r]) swap(in, l, r);
        if (in[mid] > in[r]) swap(in, mid, r);
        return mid;
    }

    private static int partition_medianof3(int[] in, int l, int r) {
        int median = medianof3(in, l, r);
        swap(in, l, median);
        int i = l + 1, j = r;
        while (i <= j) {
            while (i <= r && in[i] < in[l]) i++;
            while (j > l && in[j] > in[l]) j--;
            if (i < j) swap(in, i++, j--);
            else i++;
        }
        swap(in, l, j);
        return j;
    }

    public static void main(String[] args) {
        KthSmallestSorted solver = new KthSmallestSorted();
        int[] in = {1, 4, 5, 6, 3, 4, 2, 3, 5};
        int k = 3;
        System.out.println("Input: " + Arrays.toString(in) + ", k = " + k);
        System.out.println("QuickSelect: " + solver.quickSelect(in.clone(), k));
        System.out.println("TreeMap (Duplicates OK): " + solver.kthSmallestTreeMap(in.clone(), k));
        System.out.println("Min-Heap: " + kthSmallest4(in.clone(), k));
        System.out.println("QuickSelect (Median of 3): " + kthSmallest5(in.clone(), k));
    }
}
