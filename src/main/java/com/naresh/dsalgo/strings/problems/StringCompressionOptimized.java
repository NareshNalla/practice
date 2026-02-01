package com.naresh.dsalgo.strings.problems;

import java.util.Arrays;

public class StringCompressionOptimized {

    public static void main(String[] args) {
        char[] chars1 = "AABBCCCCDAA".toCharArray();
        int newLength1 = compress(chars1);
        System.out.println("Original: AABBCCCCDAA");
        System.out.println("Compressed: " + new String(Arrays.copyOf(chars1, newLength1))); // Prints A2B2C4D1A2

        char[] chars2 = "ABCDE".toCharArray();
        int newLength2 = compress(chars2);
        System.out.println("Original: ABCDE");
        System.out.println("Compressed: " + new String(Arrays.copyOf(chars2, newLength2))); // Prints ABCDE

        char[] chars3 = "AAABBA".toCharArray();
        int newLength3 = compress(chars3);
        System.out.println("Original: AAABBA");
        System.out.println("Compressed: " + new String(Arrays.copyOf(chars3, newLength3))); // Prints A3B2A1
    }

    /**
     * Compresses a character array in-place.
     * The compressed content will be at the beginning of the array.
     * For example, ['A','A','B','B','C','C','C'] becomes ['A','2','B','2','C','3',...].
     *
     * @param chars The character array to compress.
     * @return The new length of the compressed content in the array.
     */
    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        int writeIndex = 0; // Points to the position to write the next compressed character.
        int readIndex = 0;  // Points to the start of the group of characters being counted.

        while (readIndex < chars.length) {
            char currentChar = chars[readIndex];
            int count = 0;

            // Count consecutive occurrences of currentChar
            int runner = readIndex;
            while (runner < chars.length && chars[runner] == currentChar) {
                runner++;
                count++;
            }

            // Write the character
            chars[writeIndex++] = currentChar;

            // Write the count if it's greater than 1
            if (count > 1) {
                // Convert count to string and write each digit
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[writeIndex++] = c;
                }
            }
            
            // Move readIndex to the next new character
            readIndex = runner;
        }

        return writeIndex;
    }
}
