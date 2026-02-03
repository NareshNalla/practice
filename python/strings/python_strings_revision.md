# Python Strings Revision Notes

This document provides a quick revision guide for common string problems, including the techniques and high-level steps to solve them.

---

### 1. Longest Repeating Character Replacement

- **Problem**: Find the length of the longest substring you can get by replacing no more than `k` characters.
- **Technique**: Sliding Window
- **Steps**:
    1. Initialize a sliding window with `left` and `right` pointers and a frequency map for characters.
    2. Expand the window by moving the `right` pointer and updating the character count.
    3. Check if the current window is valid (i.e., `window_length - max_frequency <= k`).
    4. If the window is invalid, shrink it from the `left` until it becomes valid again.
    5. Keep track of the maximum valid window size found.

---

### 2. Encode and Decode Strings

- **Problem**: Design an algorithm to encode a list of strings into a single string and then decode it back to the original list.
- **Technique**: Delimiter-Based Encoding
- **Steps**:
    1. **Encode**: Iterate through the list of strings. For each string, prepend its length followed by a delimiter (e.g., `#`).
    2. **Decode**:
        - Initialize a pointer to the start of the encoded string.
        - Read characters until you find the delimiter to determine the length of the next string.
        - Extract the substring of that length.
        - Move the pointer to the start of the next length prefix and repeat.

---

### 3. Group Anagrams

- **Problem**: Group an array of strings into anagrams.
- **Technique**: Hashing (with sorted strings or character counts)
- **Steps**:
    1. Create a hash map to store groups of anagrams.
    2. Iterate through each string in the input array.
    3. For each string, create a unique key by either sorting the string or counting character frequencies.
    4. Use this key to store the string in the hash map. Strings with the same key are anagrams.
    5. Return the values of the hash map.

---

### 4. Longest Palindromic Substring

- **Problem**: Find the longest palindromic substring in a given string.
- **Technique**: Expand from Center
- **Steps**:
    1. Iterate through the string, considering each character as a potential center of a palindrome.
    2. For each character, expand outwards to find the longest palindrome for both odd-length (center is `i`) and even-length (center is `i`, `i+1`) cases.
    3. Keep track of the start and end indices of the longest palindrome found so far.
    4. Return the substring corresponding to these indices.

---

### 5. Longest Substring Without Repeating Characters

- **Problem**: Find the length of the longest substring without repeating characters.
- **Technique**: Sliding Window
- **Steps**:
    1. Initialize a sliding window with `left` and `right` pointers and a set to store characters in the current window.
    2. Expand the window by moving the `right` pointer.
    3. If the character at `right` is already in the set, shrink the window from the `left` until the duplicate is removed.
    4. Update the set with the new character and update the maximum length found.

---

### 6. Palindromic Substrings

- **Problem**: Count the number of palindromic substrings in a string.
- **Technique**: Expand from Center
- **Steps**:
    1. Initialize a counter for palindromic substrings.
    2. Iterate through the string, treating each character as a potential center.
    3. For each character, expand outwards for both odd-length (`i`, `i`) and even-length (`i`, `i+1`) palindromes.
    4. Increment the counter for each valid palindrome found.

---

### 7. Remove Spaces from a String

- **Problem**: Remove all whitespace characters from a string.
- **Technique**: String Traversal / List Comprehension
- **Steps**:
    1. **Pythonic Way**: Use a generator expression or list comprehension with `"".join()` to build a new string containing only non-whitespace characters.
    2. **Manual Way**:
        - Create an empty list.
        - Iterate through the input string.
        - If a character is not a space, add it to the list.
        - Join the list back into a string.

---

### 8. String Compression

- **Problem**: Compress a string by replacing consecutive repeated characters with the character followed by the count (e.g., "AAABBC" -> "A3B2C1").
- **Technique**: Two Pointers
- **Steps**:
    1. Initialize an empty list to store the compressed parts.
    2. Use a `read` pointer to iterate through the string and a `write` pointer (or index) to build the new string.
    3. For each character, use a nested loop to count its consecutive occurrences.
    4. Append the character and its count to the list.
    5. Move the `read` pointer to the next new character.
    6. Join the parts and return the compressed string only if it's shorter than the original.

---

### 9. Valid Anagram

- **Problem**: Determine if two strings are anagrams of each other.
- **Technique**: Hashing (Character Frequency Counting)
- **Steps**:
    1. Check if the lengths of the two strings are equal. If not, they can't be anagrams.
    2. Create a frequency map (or an array of size 26 for lowercase English letters) for each string.
    3. Compare the frequency maps. If they are identical, the strings are anagrams.
    4. **Alternative**: Sort both strings and check if they are equal.

---

### 10. Valid Palindrome

- **Problem**: Check if a string is a palindrome after converting to lowercase and removing non-alphanumeric characters.
- **Technique**: Two Pointers
- **Steps**:
    1. Preprocess the string: convert to lowercase and remove all non-alphanumeric characters.
    2. Initialize two pointers, `left` at the start and `right` at the end of the cleaned string.
    3. Move the pointers toward each other, checking if the characters at `left` and `right` are the same.
    4. If a mismatch is found, return `False`.
    5. If the pointers cross, the string is a palindrome, so return `True`.

---

### 11. Valid Parentheses

- **Problem**: Determine if a string of parentheses `()`, `{}`, `[]` is valid.
- **Technique**: Stack
- **Steps**:
    1. Initialize an empty stack.
    2. Create a hash map to store the matching pairs of parentheses (e.g., `')': '('`).
    3. Iterate through the string:
        - If an opening bracket is found, push it onto the stack.
        - If a closing bracket is found, check if the stack is empty or if the top of the stack is its matching opening bracket. If not, the string is invalid.
    4. After the loop, the string is valid only if the stack is empty.
