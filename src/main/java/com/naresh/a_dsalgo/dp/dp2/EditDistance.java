package com.naresh.a_dsalgo.dp.dp2;

/**
 * Problem: Edit Distance (Levenshtein Distance)
 * Description: Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * Operations: insert, delete, replace.
 */
public class EditDistance {
    /**
     * Algorithm: 2D DP. `dp[i][j]` is the min operations to convert word1[0...i-1] to word2[0...j-1].
     */
    public int minDistance(String word1, String word2) {
        // Pattern: DP (2D) | Time: O(m * n), Space: O(m * n)
        int m = word1.length(), n = word2.length();
        var dp = new int[m + 1][n + 1];
        // Base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i; // Delete all chars from word1
        for (int j = 0; j <= n; j++) dp[0][j] = j; // Insert all chars to word1

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // Characters match, no operation
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // Replace
                                            Math.min(dp[i - 1][j],   // Delete
                                                     dp[i][j - 1])); // Insert
                }
            }
        }
        return dp[m][n];
    }
    // FAANG Tip: This is a fundamental string DP problem. Space can be optimized to O(min(m, n)) using two rows.

    public static void main(String[] args) {
        var word1 = "horse";
        var word2 = "ros";
        var result = new EditDistance().minDistance(word1, word2);
        System.out.println("Min edit distance: " + result); // Output: 3 (delete h, delete e, replace r with s)
    }

    /*
     * Dry Run:
     * Input: word1="horse", word2="ros"
     * dp table (6x4):
     *      ""  r  o  s
     *  ""  0   1  2  3
     *  h   1   1  2  3
     *  o   2   2  1  2
     *  r   3   2  2  2
     *  s   4   3  3  2
     *  e   5   4  4  3
     * Result: dp[5][3]=3
     */
}
