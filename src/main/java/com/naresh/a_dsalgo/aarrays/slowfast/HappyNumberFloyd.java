package com.naresh.a_dsalgo.aarrays.slowfast;

/**
 * Problem: Happy Number
 * Description: Determine if a number is "happy". A happy number eventually reaches 1 when 
 * replaced by the sum of the squares of its digits. Others loop endlessly in a cycle.
 */
public class HappyNumberFloyd {
    /**
     * Algorithm: Use Floyd's Cycle-Finding Algorithm (Slow and Fast pointers). 
     * Treat the sequence of numbers as a linked list. If there's a cycle that 
     * doesn't include 1, the pointers will eventually meet. If it reaches 1, it's happy.
     */
    public boolean isHappy(int n) {
        // Pattern: Slow & Fast Pointers | Time: O(log n), Space: O(1)
        var slow = n;
        var fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow); // Move one step
            fast = getNext(getNext(fast)); // Move two steps
        }
        return fast == 1; // If fast reaches 1, it's a happy number
    }

    private int getNext(int n) {
        var sum = 0;
        while (n > 0) {
            var digit = n % 10;
            sum += digit * digit; // Sum of squares
            n /= 10;
        }
        return sum;
    }
    // FAANG Tip: Explain why O(1) space (Slow/Fast) is superior to O(log n) space (HashSet). Mention that the sequence of numbers for a non-happy number always enters a cycle (like the 4-16-37... cycle).

    public static void main(String[] args) {
        var sol = new HappyNumberFloyd();
        System.out.println("Test 19: " + sol.isHappy(19)); // Expected: true
        System.out.println("Test 2: " + sol.isHappy(2));   // Expected: false
        System.out.println("Test 16: " + sol.isHappy(16)); // Expected: false
    }
}

/**
 * Dry Run: n = 19 (Happy)
 * 1. Init: slow=19, fast=getNext(19)=82
 * 2. Iter 1: slow=getNext(19)=82, fast=getNext(getNext(82))=100
 * 3. Iter 2: slow=getNext(82)=68, fast=getNext(getNext(100))=1
 * 4. Result: fast is 1 -> returns true.
 *
 * Dry Run: n = 2 (Not Happy)
 * 1. Init: slow=2, fast=getNext(2)=4
 * 2. Iter 1: slow=4, fast=getNext(getNext(4))=37
 * 3. Iter 2: slow=16, fast=getNext(getNext(37))=89
 * ... pointers eventually meet at 42 (cycle detected) ...
 * 4. Result: fast is not 1 -> returns false.
 */
