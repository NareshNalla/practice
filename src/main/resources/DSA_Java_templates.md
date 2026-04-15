# 🚀 Ultimate Java Coding Interview Templates (Latest Java)

---

## 🧠 1. Sliding Window
```java
int left = 0, result = 0;

for (int right = 0; right < nums.length; right++) {

    while (/* condition */) {
        left++;
    }

    result = Math.max(result, right - left + 1);
}
```

## 🧠 2. HashMap (Two Sum)
```java
Map<Integer, Integer> map = new HashMap<>();

for (int i = 0; i < nums.length; i++) {
    int diff = target - nums[i];

    if (map.containsKey(diff)) {
        return new int[]{map.get(diff), i};
    }

    map.put(nums[i], i);
}
```

## 🧠 3. Binary Search
```java
int left = 0, right = nums.length - 1;

while (left <= right) {
    int mid = left + (right - left) / 2;

    if (nums[mid] == target) return mid;
    else if (nums[mid] < target) left = mid + 1;
    else right = mid - 1;
}
```

## 🧠 4. Binary Search on Answer
```java
int left = 1, right = max;

while (left < right) {
    int mid = left + (right - left) / 2;

    if (canSolve(mid)) right = mid;
    else left = mid + 1;
}

return left;
```

## 🧠 5. Prefix Sum + HashMap
```java
Map<Integer, Integer> map = new HashMap<>();
map.put(0, 1);

int sum = 0, count = 0;

for (int num : nums) {
    sum += num;

    count += map.getOrDefault(sum - k, 0);

    map.put(sum, map.getOrDefault(sum, 0) + 1);
}
```

## 🧠 6. Backtracking
```java
void backtrack(List<Integer> temp) {

    result.add(new ArrayList<>(temp));

    for (int i = 0; i < nums.length; i++) {

        temp.add(nums[i]);

        backtrack(temp);

        temp.remove(temp.size() - 1);
    }
}
```

## 🌳 7. DFS (Tree)
```java
void dfs(TreeNode root) {
    if (root == null) return;

    dfs(root.left);
    dfs(root.right);
}
```

## 🌳 8. BFS (Tree)
```java
Queue<TreeNode> queue = new ArrayDeque<>();
queue.offer(root);

while (!queue.isEmpty()) {

    TreeNode node = queue.poll();

    if (node.left != null) queue.offer(node.left);
    if (node.right != null) queue.offer(node.right);
}
```

## 🌐 9. Graph BFS
```java
Queue<Integer> q = new ArrayDeque<>();
boolean[] visited = new boolean[n];

q.offer(start);
visited[start] = true;

while (!q.isEmpty()) {

    int node = q.poll();

    for (int nei : graph.get(node)) {
        if (!visited[nei]) {
            q.offer(nei);
            visited[nei] = true;
        }
    }
}
```

## 🔝 10. Heap (Top K)
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

for (int num : nums) {
    pq.offer(num);

    if (pq.size() > k) {
        pq.poll();
    }
}
```

## 📚 11. Monotonic Stack
```java
Deque<Integer> stack = new ArrayDeque<>();

for (int num : nums) {

    while (!stack.isEmpty() && stack.peek() < num) {
        stack.pop();
    }

    stack.push(num);
}
```

## 🔗 12. Fast & Slow Pointer
```java
ListNode slow = head, fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

## 📈 13. Dynamic Programming (1D)
```java
int[] dp = new int[n];

dp[0] = base;

for (int i = 1; i < n; i++) {
    dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
}
```

## 📊 14. Dynamic Programming (2D)
```java
int[][] dp = new int[m][n];

for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {

        dp[i][j] = /* transition */;
    }
}
```

## 📆 15. Intervals Merge
```java
Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

List<int[]> res = new ArrayList<>();

for (int[] in : intervals) {

    if (res.isEmpty() || res.get(res.size() - 1)[1] < in[0]) {
        res.add(in);
    } else {
        res.get(res.size() - 1)[1] =
            Math.max(res.get(res.size() - 1)[1], in[1]);
    }
}
```