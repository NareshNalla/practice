# DSA Problem Summary

This table summarizes the Data Structures & Algorithms problems implemented, adhering to the `java_dsa_skill.md` standards.

| Problem Name                                     | Pattern                     | Time Complexity          | Space Complexity         | LeetCode / Blind75 / NeetCode |
| :----------------------------------------------- | :-------------------------- | :----------------------- | :----------------------- | :---------------------------- |
| **Tree Problems**                                |                             |                          |                          |                               |
| Same Tree                                        | Recursion                   | O(min(N, M))             | O(min(H1, H2))           | LeetCode 100                  |
| Invert Binary Tree                               | DFS (Recursive)             | O(n)                     | O(h)                     | LeetCode 226 / Blind75        |
| Balanced Binary Tree                             | DFS (Post-order)            | O(n)                     | O(h)                     | LeetCode 110                  |
| Diameter of Binary Tree                          | DFS (Post-order)            | O(n)                     | O(h)                     | LeetCode 543                  |
| Subtree of Another Tree                          | Recursive Comparison        | O(n*m)                   | O(h)                     | LeetCode 572                  |
| Binary Tree Right Side View                      | DFS (Root-Right-Left)       | O(n)                     | O(h)                     | LeetCode 199                  |
| Kth Smallest Element in a BST                    | Iterative In-order          | O(h + k)                 | O(h)                     | LeetCode 230                  |
| Binary Tree Maximum Path Sum                     | DFS (Post-order)            | O(n)                     | O(h)                     | LeetCode 124 / Blind75        |
| Maximum Depth of Binary Tree                     | DFS (Recursive)             | O(n)                     | O(h)                     | LeetCode 104 / Blind75        |
| Validate Binary Search Tree                      | DFS (Range Validation)      | O(n)                     | O(h)                     | LeetCode 98 / Blind75         |
| Count Good Nodes in Binary Tree                  | DFS (Path Tracking)         | O(n)                     | O(h)                     | LeetCode 1448                 |
| Lowest Common Ancestor of a BST                  | BST Traversal               | O(h)                     | O(1)                     | LeetCode 235                  |
| Binary Tree Level Order Traversal                | BFS                         | O(n)                     | O(n)                     | LeetCode 102 / Blind75        |
| Serialize and Deserialize Binary Tree            | Pre-order DFS               | O(n)                     | O(n)                     | LeetCode 297                  |
| Construct Binary Tree from Preorder and Inorder  | Recursive Construction      | O(n)                     | O(n)                     | LeetCode 105                  |
| **Dynamic Programming (DP1)**                    |                             |                          |                          |                               |
| Word Break                                       | DP (1D)                     | O(n^3)                   | O(n)                     | LeetCode 139 / Blind75        |
| Coin Change                                      | DP (1D)                     | O(n * amount)            | O(amount)                | LeetCode 322 / Blind75        |
| Decode Ways                                      | DP (Space Optimized)        | O(n)                     | O(1)                     | LeetCode 91                   |
| House Robber                                     | DP (Space Optimized)        | O(n)                     | O(1)                     | LeetCode 198 / Blind75        |
| N-th Fibonacci Number                            | Iterative DP                | O(n)                     | O(1)                     | LeetCode 509                  |
| House Robber II                                  | DP (Split Linear)           | O(n)                     | O(1)                     | LeetCode 213                  |
| Climbing Stairs                                  | DP (Space Optimized)        | O(n)                     | O(1)                     | LeetCode 70 / Blind75         |
| Maximum Subarray                                 | Kadane's Algorithm          | O(n)                     | O(1)                     | LeetCode 53 / Blind75         |
| Min Cost Climbing Stairs                         | DP (Space Optimized)        | O(n)                     | O(1)                     | LeetCode 746                  |
| Palindromic Substrings                           | Expand Around Center        | O(n^2)                   | O(1)                     | LeetCode 647                  |
| Maximum Product Subarray                         | DP (Two States)             | O(n)                     | O(1)                     | LeetCode 152 / Blind75        |
| Best Time to Buy and Sell Stock                  | One-pass Greedy/DP          | O(n)                     | O(1)                     | LeetCode 121 / Blind75        |
| Partition Equal Subset Sum                       | DP (Subset Sum)             | O(n * sum)               | O(sum)                   | LeetCode 416                  |
| Longest Palindromic Substring                    | Expand Around Center        | O(n^2)                   | O(1)                     | LeetCode 5 / Blind75          |
| Longest Increasing Subsequence                   | Binary Search / Patience Sorting | O(n log n)               | O(n)                     | LeetCode 300 / Blind75        |
| **Dynamic Programming (DP2)**                    |                             |                          |                          |                               |
| Minimum/Maximum Path Sum in Grid                 | DP (2D Space Optimized)     | O(m * n)                 | O(n)                     | LeetCode 64 (Min Path Sum)    |
| Target Sum                                       | DP (Subset Sum)             | O(n * sum)               | O(sum)                   | LeetCode 494                  |
| Unique Paths                                     | DP (2D Space Optimized)     | O(m * n)                 | O(n)                     | LeetCode 62 / Blind75         |
| Coin Change II                                   | DP (1D, Unbounded Knapsack) | O(amount * num_coins)    | O(amount)                | LeetCode 518                  |
| Edit Distance                                    | DP (2D)                     | O(m * n)                 | O(m * n)                 | LeetCode 72                   |
| Longest Increasing Subsequence (LIS)             | Binary Search / Patience Sorting | O(n log n)               | O(n)                     | LeetCode 300 / Blind75        |
| Burst Balloons                                   | Range DP                    | O(n^3)                   | O(n^2)                   | LeetCode 312                  |
| Interleaving String                              | DP (2D)                     | O(m * n)                 | O(n)                     | LeetCode 97                   |
| Distinct Subsequences                            | DP (2D)                     | O(s * t)                 | O(t)                     | LeetCode 115                  |
| Longest Common Subsequence                       | DP (2D)                     | O(m * n)                 | O(m * n)                 | LeetCode 1143                 |
| Regular Expression Matching                      | DP (2D)                     | O(m * n)                 | O(m * n)                 | LeetCode 10                   |
| Longest Increasing Path in a Matrix              | DFS + Memoization           | O(m * n)                 | O(m * n)                 | LeetCode 329                  |
| Best Time to Buy and Sell Stock with Cooldown    | DP (State Machine)          | O(n)                     | O(1)                     | LeetCode 309                  |
| **Graph Problems**                               |                             |                          |                          |                               |
| Clone Graph                                      | DFS + HashMap               | O(V + E)                 | O(V)                     | LeetCode 133                  |
| Word Ladder                                      | BFS (Shortest Path)         | O(N * M^2)               | O(N * M)                 | LeetCode 127                  |
| Walls and Gates                                  | Multi-source BFS            | O(m * n)                 | O(m * n)                 | LeetCode 286                  |
| Course Schedule                                  | BFS (Topological Sort)      | O(V + E)                 | O(V + E)                 | LeetCode 207 / Blind75        |
| Graph Valid Tree                                 | Union-Find                  | O(V + Eα(V))             | O(V)                     | LeetCode 261                  |
| Rotting Oranges                                  | Multi-source BFS            | O(m * n)                 | O(m * n)                 | LeetCode 994 / Blind75        |
| Max Area of Island                               | DFS (Area Calculation)      | O(m * n)                 | O(m * n)                 | LeetCode 695                  |
| Number of Islands                                | DFS (Grid Traversal)        | O(m * n)                 | O(m * n)                 | LeetCode 200 / Blind75        |
| Course Schedule II                               | BFS (Topological Sort)      | O(V + E)                 | O(V + E)                 | LeetCode 210                  |
| Surrounded Regions                               | Boundary DFS                | O(m * n)                 | O(m * n)                 | LeetCode 130                  |
| Redundant Connection                             | Union-Find                  | O(V + Eα(V))             | O(V)                     | LeetCode 684                  |
| Pacific Atlantic Water Flow                      | Multi-source DFS            | O(m * n)                 | O(m * n)                 | LeetCode 417                  |
| Number of Connected Components in Undirected Graph | Union-Find                  | O(V + Eα(V))             | O(V)                     | LeetCode 323                  |
| **Arrays (Sliding Window)**                      |                             |                          |                          |                               |
| Permutation in String                            | Sliding Window (Fixed)      | O(n)                     | O(1)                     | LeetCode 567                  |
| Sliding Window Maximum                           | Monotonic Deque             | O(n)                     | O(k)                     | LeetCode 239                  |
| Minimum Window Substring                         | Sliding Window              | O(s + t)                 | O(t)                     | LeetCode 76 / Blind75         |
| Maximum Average Subarray I                       | Sliding Window              | O(n)                     | O(1)                     | LeetCode 643                  |
| Best Time to Buy and Sell Stock                  | Two Pointers / Sliding Window | O(n)                     | O(1)                     | LeetCode 121 / Blind75        |
| Longest Repeating Character Replacement          | Sliding Window (Variable)   | O(n)                     | O(1)                     | LeetCode 424 / Blind75        |
| Longest Substring Without Repeating Characters   | Sliding Window              | O(n)                     | O(min(n, alphabet_size)) | LeetCode 3 / Blind75          |
| **Strings (Problems)**                           |                             |                          |                          |                               |
| Anagram Check                                    | Frequency Array             | O(n)                     | O(1)                     | LeetCode 242                  |
| String Encode and Decode                         | Length-Prefixing            | O(n)                     | O(n)                     | LeetCode 271                  |
| Group Anagrams                                   | Hashing with Frequency Array | O(n * k)                 | O(n * k)                 | LeetCode 49 / Blind75         |
| Remove Spaces                                    | String Building             | O(n)                     | O(n)                     |                               |
| Find Max Length (Min/Max Word)                   | String Split / Iteration    | O(n)                     | O(w)                     |                               |
| In-Place String Reverse                          | Two Pointers / In-place     | O(n)                     | O(n)                     |                               |
| Longest Palindromic Substring                    | Expand Around Center        | O(n^2)                   | O(1)                     | LeetCode 5 / Blind75          |
| String Compression                               | Two-Pointer (Read/Write)    | O(n)                     | O(1)                     | LeetCode 443                  |
| Sentence Similarity                              | HashSet Lookup              | O(N + P)                 | O(P)                     | LeetCode 734                  |
| Sentence Similarity II                           | Union-Find (DSU)            | O(P*α(V) + N*α(V))       | O(V)                     | LeetCode 737                  |
| Sentence Similarity III                          | Two Pointers                | O(N + M)                 | O(N + M)                 | LeetCode 1813                 |
