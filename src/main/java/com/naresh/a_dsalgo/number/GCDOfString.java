package com.naresh.a_dsalgo.number;

public class GCDOfString {
    public static void main(String[] args) {
        var sol = new GCDOfString();
        System.out.println("GCD: " + sol.gcdOfStrings("ABCABC", "ABC"));
    }

    /**
     * Algorithm:
     * 1. Validate: If (str1 + str2) != (str2 + str1), no common divisor string exists.
     * 2. Calculate: The length of the largest repeating unit is the GCD of both lengths.
     * 3. Result: Return the prefix of str1 with the calculated GCD length.
     */
    public String gcdOfStrings(String str1, String str2) {
        // Pattern: String Math / GCD | Time: O(N + M), Space: O(N + M)
        //key check: if a common divisor exists, both concat orders must be equal
        if (!(str1 + str2).equals(str2 + str1)) return "";
        //GCD of length gives the length of the largest repeating tile
        int gcdLen = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLen);
    }

    private int gcd(int a, int b) {
        // Pattern: Euclidean Algorithm | Time: O(log(min(a,b))), Space: O(log(min(a,b)))
        if (b == 0) return a;
        return gcd(b, a % b); // b==0 -> a is GCD
    }
}
