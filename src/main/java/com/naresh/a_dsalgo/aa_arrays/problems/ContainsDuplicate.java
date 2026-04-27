package com.naresh.a_dsalgo.aa_arrays.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args){
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicateSet(nums));

    }

    private static boolean containsDuplicate(int[] nums) {
        /*
        Time complexity: O(n)
        Space complexity: O(n)
         */
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
    private static boolean containsDuplicateSet(int[] nums) {
        /*
        Time complexity: O(n)
        Space complexity: O(n)
         */
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
