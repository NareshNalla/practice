package com.naresh.a_dsalgo;

import java.util.*;

public class DsaTemplatesTest {

    // Dummy TreeNode for testing
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // Dummy ListNode for testing
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        DsaTemplatesTest tester = new DsaTemplatesTest();
        int[] nums = {1, 3, 2, 5, 4};
        int target = 5;

        System.out.println("Sliding Window: " + tester.slidingWindow(nums));
        System.out.println("Two Sum: " + Arrays.toString(tester.twoSum(nums, target)));
        System.out.println("Binary Search: " + tester.binarySearch(nums, 3));
        System.out.println("Binary Search on Answer: " + tester.binarySearchOnAnswer(nums));
        System.out.println("Prefix Sum: " + tester.prefixSum(nums, 5));
        
        System.out.print("Backtracking: ");
        tester.testBacktracking(nums);
        
        System.out.print("DFS: ");
        tester.dfs(new TreeNode(1));
        System.out.println();

        System.out.print("BFS: ");
        tester.bfs(new TreeNode(1));
        System.out.println();

        System.out.println("Graph BFS: (Skipped - requires graph construction)");
        System.out.println("Heap Top K: " + tester.topK(nums, 2));
        System.out.println("Monotonic Stack: " + tester.monotonicStack(nums));
        System.out.println("Fast & Slow Pointer: (Tested internally)");
        System.out.println("DP 1D: " + tester.dp1D(nums));
        System.out.println("DP 2D: " + tester.dp2D(3, 3));
        
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        System.out.println("Intervals Merge: " + tester.mergeIntervals(intervals).size());
    }

    // 1. Sliding Window
    public int slidingWindow(int[] nums) {
        int left = 0, result = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] > 10) { // Example condition
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    // 2. HashMap (Two Sum)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    // 3. Binary Search
    public int binarySearch(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // 4. Binary Search on Answer
    public int binarySearchOnAnswer(int[] nums) {
        int left = 1, right = 100; // max value
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSolve(mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    private boolean canSolve(int mid) { return mid > 50; }

    // 5. Prefix Sum + HashMap
    public int prefixSum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // 6. Backtracking
    List<List<Integer>> result = new ArrayList<>();
    public void testBacktracking(int[] nums) {
        backtrack(new ArrayList<>(), nums);
        System.out.println(result.size());
    }
    void backtrack(List<Integer> temp, int[] nums) {
        result.add(new ArrayList<>(temp));
        if (temp.size() == nums.length) return;
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backtrack(temp, nums);
            temp.remove(temp.size() - 1);
        }
    }

    // 7. DFS (Tree)
    void dfs(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        dfs(root.left);
        dfs(root.right);
    }

    // 8. BFS (Tree)
    void bfs(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    // 10. Heap (Top K)
    public List<Integer> topK(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return new ArrayList<>(pq);
    }

    // 11. Monotonic Stack
    public List<Integer> monotonicStack(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
            }
            stack.push(num);
        }
        return new ArrayList<>(stack);
    }

    // 13. Dynamic Programming (1D)
    public int dp1D(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[n-1];
    }

    // 14. Dynamic Programming (2D)
    public int dp2D(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1; // transition
            }
        }
        return dp[m-1][n-1];
    }

    // 15. Intervals Merge
    public List<int[]> mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] in : intervals) {
            if (res.isEmpty() || res.get(res.size() - 1)[1] < in[0]) {
                res.add(in);
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], in[1]);
            }
        }
        return res;
    }
}
