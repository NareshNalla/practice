package com.naresh.a_dsalgo.ag_heap.problems;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 Smash the two heavlest stones repeatedly . Return the weight of the last stone (or 0 if none remain).
 TIme O( n long n) Space O (n)
 */
public class LastStoneWeight {
//reverseOrder() flips PriorityQueue into a max-heap
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) {
            pq.offer(s);
        }
        while (pq.size() > 1) {
            int y = pq.poll(), x = pq.poll();
            //equal stones vanish; push remainder only if different
            if (x != y) {
                pq.offer(y - x);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        LastStoneWeight sol = new LastStoneWeight();
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        System.out.println("Result 1: " + sol.lastStoneWeight(stones1)); // Expected: 1

        int[] stones2 = {1};
        System.out.println("Result 2: " + sol.lastStoneWeight(stones2)); // Expected: 1

        int[] stones3 = {2, 2};
        System.out.println("Result 3: " + sol.lastStoneWeight(stones3)); // Expected: 0
    }
}
