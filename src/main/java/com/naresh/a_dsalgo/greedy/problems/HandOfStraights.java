package com.naresh.a_dsalgo.greedy.problems;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap; // TreeMap keeps keys sorted, essential for greedy approach

/**
 * Problem: Hand of Straights (LeetCode 846)
 * Description: Determine if a hand of cards can be rearranged into groups, where each group
 * is a straight of `groupSize` consecutive cards.
 */
public class HandOfStraights {

    /**
     * Algorithm: Greedy approach using a TreeMap to count card frequencies.
     * Repeatedly find the smallest available card and attempt to form a straight of `groupSize`.
     * If any card in the sequence is missing or its count is zero, return false.
     *
     * @param hand An array of integers representing the cards.
     * @param groupSize The desired size of each straight group.
     * @return True if the hand can be rearranged into straights, false otherwise.
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // Pattern: Greedy (TreeMap) | Time: O(N log N), Space: O(M)
        if (hand == null || hand.length == 0) return true; // Empty hand is valid
        if (groupSize <= 0) throw new IllegalArgumentException("Group size must be positive.");
        if (hand.length % groupSize != 0) return false; // Cannot form equal groups

        var cardCounts = new TreeMap<Integer, Integer>(); // Stores card -> frequency, keeps keys sorted
        for (var card : hand) cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1); // Populate frequencies

        while (!cardCounts.isEmpty()) { // While there are still cards to group
            var startCard = cardCounts.firstKey(); // Get smallest card
            for (var i = 0; i < groupSize; i++) { // Try to form a straight
                var currentCard = startCard + i;
                if (!cardCounts.containsKey(currentCard) || cardCounts.get(currentCard) == 0) return false; // Missing card
                cardCounts.put(currentCard, cardCounts.get(currentCard) - 1); // Decrement count
                if (cardCounts.get(currentCard) == 0) cardCounts.remove(currentCard); // Remove if count is zero
            }
        }
        return true; // All cards successfully grouped
    }
    // FAANG Tip: TreeMap is crucial for efficient greedy selection of the smallest card. Similar to "Divide Array in Sets of K Consecutive Numbers".

    public static void main(String[] args) {
        var solution = new HandOfStraights();

        var hand1 = new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8};
        var groupSize1 = 3;
        System.out.println("Hand: " + Arrays.toString(hand1) + ", Group Size: " + groupSize1 +
                           " -> Can form straights: " + solution.isNStraightHand(hand1, groupSize1)); // Expected: true

        var hand2 = new int[]{1, 2, 3, 4, 5};
        var groupSize2 = 4;
        System.out.println("Hand: " + Arrays.toString(hand2) + ", Group Size: " + groupSize2 +
                           " -> Can form straights: " + solution.isNStraightHand(hand2, groupSize2)); // Expected: false

        var hand3 = new int[]{1, 2, 3, 4, 5, 6};
        var groupSize3 = 2;
        System.out.println("Hand: " + Arrays.toString(hand3) + ", Group Size: " + groupSize3 +
                           " -> Can form straights: " + solution.isNStraightHand(hand3, groupSize3)); // Expected: true

        var hand4 = new int[]{1, 2, 3};
        var groupSize4 = 2;
        System.out.println("Hand: " + Arrays.toString(hand4) + ", Group Size: " + groupSize4 +
                           " -> Can form straights: " + solution.isNStraightHand(hand4, groupSize4)); // Expected: false

        var hand5 = new int[]{};
        var groupSize5 = 3;
        System.out.println("Hand: " + Arrays.toString(hand5) + ", Group Size: " + groupSize5 +
                           " -> Can form straights: " + solution.isNStraightHand(hand5, groupSize5)); // Expected: true

        var hand6 = new int[]{1, 1, 2, 2, 3, 3};
        var groupSize6 = 3;
        System.out.println("Hand: " + Arrays.toString(hand6) + ", Group Size: " + groupSize6 +
                           " -> Can form straights: " + solution.isNStraightHand(hand6, groupSize6)); // Expected: true

        var hand7 = new int[]{1, 2, 4, 5, 6};
        var groupSize7 = 3;
        System.out.println("Hand: " + Arrays.toString(hand7) + ", Group Size: " + groupSize7 +
                           " -> Can form straights: " + solution.isNStraightHand(hand7, groupSize7)); // Expected: false
    }
}
