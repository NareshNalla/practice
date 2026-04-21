package com.naresh.a_dsalgo.strings.problems;

import java.util.*;

public class EncodeDecode {
    public static void main(String[] args) {
        var list = List.of("hello", "world", "encode#decode", "123");
        String encoded = encode(list);
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + decodeString(encoded));
    }

    public static String encode(List<String> strs) {
        // Pattern: Length-Prefixing | Time: O(n), Space: O(n)
        if (strs == null || strs.isEmpty()) return "";
        var sb = new StringBuilder();
        for (String s : strs)
            sb.append(s.length()).append("#").append(s);
        return sb.toString();
    }

    public static List<String> decodeString(String s) {
        // Pattern: Length-Prefixing Parsing | Time: O(n), Space: O(n)
        if (s == null || s.isEmpty()) return new ArrayList<>();
        var res = new ArrayList<String>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(s.substring(i, j));
            i = j+1;
            j = i + len;
            res.add(s.substring(i, j));
            i = j;
        }
        return res;
    }
}
