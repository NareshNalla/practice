/*
Kth Smallest Element in Array - Patterns & Steps

*/

package com.naresh.dsalgo.arrays.problems;

import java.util.*;

public class KthSmallestSorted {
    // Pattern: QuickSelect (Random Pivot), Avg O(N), Worst O(N^2), Space O(1)
    public static int quickSelect(int[] nums, int k) {
        // Step 1: Call helper to find kth smallest (0-based index)
        return quickSelectHelper(nums, 0, nums.length - 1, k - 1);
    }

    private static int quickSelectHelper(int[] nums, int left, int right, int k) {
        // Step 2: If only one element left, return it
        if (left == right) return nums[left];
        // Step 3: Pick a random pivot index in range
        int pivotIndex = left + new Random().nextInt(right - left + 1);
        // Step 4: Partition the array around the pivot and get its final position
        pivotIndex = partition(nums, left, right, pivotIndex);
        // Step 5: If pivot is at kth position, return it
        if (k == pivotIndex) return nums[k];
        // Step 6: If k is less, search left part
        else if (k < pivotIndex) return quickSelectHelper(nums, left, pivotIndex - 1, k);
        // Step 7: If k is more, search right part
        else return quickSelectHelper(nums, pivotIndex + 1, right, k);
    }

    private static int partition(int[] nums, int left, int right, int pivotIndex) {
        // Step 1: Move pivot to end
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storeIndex = left;
        // Step 2: Move all elements smaller than pivot to the left
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        // Step 3: Move pivot to its final place
        swap(nums, right, storeIndex);
        return storeIndex;
    }

    // Pattern: Sorting, Time O(N log N), Space O(1)
    public static int kthSmallest2(int[] in, int k) {
        // Step 1: Check for valid k
        if (k > in.length)
            return Integer.MIN_VALUE;
        // Step 2: Sort the array
        Arrays.sort(in);
        // Step 3: Return the kth smallest (0-based index)
        return in[k - 1];
    }

    // Pattern: TreeSet, Time O(N log N), Space O(N)
    public static int kthSmallestTreeSet(int[] in, int k) {
        // Step 1: Check for valid k
        if (k > in.length)
            return Integer.MIN_VALUE;
        // Step 2: Insert all elements into a TreeSet (sorted, unique)
        SortedSet<Integer> oset = new TreeSet<>();
        for (int x : in)
            oset.add(x);
        int count = 0;
        // Step 3: Iterate to the kth element
        for (int x : oset) {
            ++count;
            if (count == k)
                return x;
        }
        return Integer.MIN_VALUE;
    }

    // Pattern: Min-Heap (PriorityQueue), Time O(N + k log N), Space O(N)
    public static int kthSmallest4(int[] in, int k) {
        // Step 1: Check for valid k
        if (k > in.length)
            return Integer.MIN_VALUE;
        // Step 2: Add all elements to a min-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : in)
            pq.add(x);
        int res = Integer.MIN_VALUE;
        // Step 3: Remove the smallest k times
        for (int i = 0; i < k; ++i)
            res = pq.remove();
        return res;
    }

    // Pattern: QuickSelect (Median-of-3), Avg O(N), Worst O(N^2), Space O(1)
    public static int kthSmallest5(int[] in, int k) {
        // Step 1: Check for valid k
        if (k > in.length)
            return Integer.MIN_VALUE;
        int l = 0, r = in.length - 1, p = 0;
        // Step 2: Partition and search for kth smallest
        while (l <= r) {
            p = partition_medianof3(in, l, r);
            if (k == p - l + 1)
                break;
            if (k < p - l + 1)
                r = p - 1;
            else {
                k = k - (p - l + 1);
                l = p + 1;
            }
        }
        // Step 3: Return the kth smallest
        return in[p];
    }

    private static void swap(int[] in, int i, int j) {
        // Step: Swap two elements
        int tmp = in[i];
        in[i] = in[j];
        in[j] = tmp;
    }

    private static int medianof3(int[] in, int l, int r) {
        // Step 1: Find median of three for better pivot
        if (r - l < 2)
            return l;
        int mid = (l + r) / 2;
        int smallest1, smallest2;
        if (in[l] < in[mid]) {
            smallest1 = in[l];
            smallest2 = in[mid];
        } else {
            smallest1 = in[mid];
            smallest2 = in[l];
        }
        if (in[r] > smallest2)
            return smallest2;
        else if (in[r] > smallest1)
            return in[r];
        else
            return smallest1;
    }

    private static int partition_medianof3(int[] in, int l, int r) {
        // Step 1: Use median-of-three for pivot selection
        int i = l + 1, j = r;
        int median = medianof3(in, l, r);
        swap(in, l, median);
        // Step 2: Partition logic
        while (i < j) {
            while (i <= r && in[i] < in[l])
                ++i;
            while (j > l && in[j] > in[l])
                --j;
            if (i < j)
                swap(in, i, j);
        }
        // Step 3: Move pivot to its final place
        swap(in, l, j);
        return j;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] in = new int[n];
        for (int i = 0; i < n; ++i)
            in[i] = n - i;
        int[] in1 = {1,4,5,6,2,3,4,2,3,5};
        System.out.println(Arrays.toString(in1));
        int k = new Random().nextInt(n) + 1;
        System.out.println("k = " + k);
        System.out.println("Optimized QuickSelect: " + quickSelect(Arrays.copyOf(in1, in1.length), k));
        System.out.println("Sorting: " + kthSmallest2(Arrays.copyOf(in1, in1.length), k));
        System.out.println("TreeSet: " + kthSmallestTreeSet(Arrays.copyOf(in1, in1.length), k));
        System.out.println("Min-Heap: " + kthSmallest4(Arrays.copyOf(in1, in1.length), k));
        System.out.println("QuickSelect (Median of 3): " + kthSmallest5(Arrays.copyOf(in1, in1.length), k));
    }

}