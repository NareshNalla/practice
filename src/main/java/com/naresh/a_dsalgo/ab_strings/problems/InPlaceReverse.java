package com.naresh.a_dsalgo.ab_strings.problems;

/**
 * Problem: In-Place String Reverse
 * Description: Reverse a string in-place.
 */
public class InPlaceReverse {
    public static void main(String[] args) {
        System.out.println("Original: abcd, Reversed: " + inPlace("abcd")); // Expected: dcba
        System.out.println("Original: hello, Reversed: " + inPlace("hello")); // Expected: olleh
        System.out.println("Original: a, Reversed: " + inPlace("a")); // Expected: a
        System.out.println("Original: , Reversed: " + inPlace("")); // Expected:
    }

    /**
     * Algorithm: Use two pointers, one at the beginning and one at the end. Swap characters and move pointers inwards.
     */
    public static String inPlace(String input) {
        // Pattern: Two Pointers / In-place | Time: O(n), Space: O(n) (due to StringBuilder copy)
        if (input == null || input.length() <= 1) return input;
        final StringBuilder sb = new StringBuilder(input);
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
        return sb.toString();
    }
    // FAANG Tip: For true in-place (O(1) space) in Java, you'd typically work with a char[] directly. StringBuilder creates a copy.
}

/**
 * Dry Run:
 * Input: input = "abcd"
 *
 * 1. Initialization:
 *    sb = "abcd"
 *    left = 0, right = 3
 *
 * 2. Loop Iteration 1 (left = 0, right = 3):
 *    - left < right (0 < 3) is true.
 *    - temp = sb.charAt(0) = 'a'
 *    - sb.setCharAt(0, sb.charAt(3)) -> sb becomes "dbcd"
 *    - sb.setCharAt(3, temp) -> sb becomes "dcba"
 *    - left = 1, right = 2
 *
 * 3. Loop Iteration 2 (left = 1, right = 2):
 *    - left < right (1 < 2) is true.
 *    - temp = sb.charAt(1) = 'c'
 *    - sb.setCharAt(1, sb.charAt(2)) -> sb becomes "dbba" (error in manual trace, should be "dcbA" if previous was "dcba")
 *      Correction: sb.setCharAt(1, sb.charAt(2)) -> sb.charAt(2) is 'c'. So sb becomes "dcbA"
 *      Correction: sb.setCharAt(1, sb.charAt(2)) -> sb.charAt(2) is 'c'. So sb becomes "dcbA"
 *      Let's re-trace carefully:
 *      Initial: sb = "abcd", left=0, right=3
 *      Iter 1: temp='a'. sb.setCharAt(0, 'd') -> "dbcd". sb.setCharAt(3, 'a') -> "dcba". left=1, right=2.
 *      Iter 2: temp='c'. sb.setCharAt(1, 'c') -> "dcba". sb.setCharAt(2, 'c') -> "dcba". left=2, right=1.
 *
 * 4. Loop Condition Check:
 *    - left < right (2 < 1) is false. Loop terminates.
 *
 * 5. Return sb.toString() -> "dcba"
 *
 * Corrected Dry Run (Iter 2):
 * Input: input = "abcd"
 *
 * 1. Initialization:
 *    sb = "abcd"
 *    left = 0, right = 3
 *
 * 2. Loop Iteration 1 (left = 0, right = 3):
 *    - left < right (0 < 3) is true.
 *    - temp = sb.charAt(0) = 'a'
 *    - sb.setCharAt(0, sb.charAt(3)) -> sb.setCharAt(0, 'd') -> sb is now "dbcd"
 *    - sb.setCharAt(3, temp) -> sb.setCharAt(3, 'a') -> sb is now "dcba"
 *    - left = 1, right = 2
 *
 * 3. Loop Iteration 2 (left = 1, right = 2):
 *    - left < right (1 < 2) is true.
 *    - temp = sb.charAt(1) = 'c'
 *    - sb.setCharAt(1, sb.charAt(2)) -> sb.setCharAt(1, 'c') -> sb is now "dcba" (no change visually)
 *    - sb.setCharAt(2, temp) -> sb.setCharAt(2, 'c') -> sb is now "dcba" (no change visually)
 *    - left = 2, right = 1
 *
 * 4. Loop Condition Check:
 *    - left < right (2 < 1) is false. Loop terminates.
 *
 * 5. Return sb.toString() -> "dcba"
 */
