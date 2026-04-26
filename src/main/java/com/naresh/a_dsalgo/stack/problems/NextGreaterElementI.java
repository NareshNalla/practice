package com.naresh.a_dsalgo.stack.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Problem: Next Greater Element I
 * Description: Find the next greater element for each value in nums1 in the reference array nums2.
 */
public class NextGreaterElementI {
    /**
     * Algorithm: Use a monotonic stack to process nums2. When a larger element is found, it 
     * is the "next greater" for elements on the stack. Store results in a HashMap.
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Pattern: Monotonic Stack | Time: O(n + m), Space: O(m)
        var stack = new ArrayDeque<Integer>();
        var map = HashMap.<Integer, Integer>newHashMap(nums2.length);
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num); // Found next greater
            }
            stack.push(num); // Add to monotonic stack
        }
        var result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1); // Lookup or default
        }
        return result;
    }
    // FAANG Tip: Monotonic stacks are the go-to for "nearest/next" problems. Mention O(n+m) linear time and why Deque is preferred over the legacy Stack class.

    public static void main(String[] args) {
        var sol = new NextGreaterElementI();
        var nums1 = new int[]{4, 1, 2};
        var nums2 = new int[]{1, 3, 4, 2};
        System.out.println("Result: " + Arrays.toString(sol.nextGreaterElement(nums1, nums2))); // [-1, 3, -1]
    }
}
