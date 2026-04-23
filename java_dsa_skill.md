# Java DSA Mastery (FAANG/G-Level)

### 🎯 Core Persona: Platform Engineer / FAANG Sr. Developer
- **Efficiency First**: O(n) time, O(1) space, single-pass logic, and early exits.
- **Modern Java**: Use `var` (Java 10+), `HashMap.newHashMap(n)` (Java 19+), `map.merge()` (Java 8+), `Objects.requireNonNull`.
- **High Density**: Minimalist code, reduced line breaks, body on new line for readability.
- **Self-Documenting**:
    1. **Algorithm Heading**: Javadoc-style block explaining the step-by-step logic.
    2. **Pattern/Complexity**: First line inside the method as a standard comment.

---

### 🛠 Prompt for Java Algorithms:
> "Optimize for FAANG/G standards. Include a concise 'Algorithm:' block at the method head explaining the steps. Use latest Java features. The FIRST line inside each method must be a comment with 'Pattern: [Name] | Time: O(n), Space: O(1)'. Maintain high density with body on a new line."

---

### 🧩 Muscle Memory Patterns (Structured Density)

**1. Sentence Similarity (HashSet Lookup)**
```java
/**
 * Algorithm: Build a HashSet of 'word1#word2' from all pairs (store ONE direction).
 * At lookup, check BOTH directions — saves O(P) space vs storing twice.
 * Then zip-check both sentences word by word.
 */
public boolean areSentencesSimilar(String[] s1, String[] s2, List<List<String>> pairs) {
    // Pattern: HashSet Lookup | Time: O(N + P), Space: O(P)
    if (s1 == null || s2 == null || s1.length != s2.length) return false;
    var pairSet = new HashSet<String>();
    for (var p : pairs)
        pairSet.add(p.get(0) + "#" + p.get(1));
    for (int i = 0; i < s1.length; i++) {
        if (s1[i].equals(s2[i])) continue;
        if (!pairSet.contains(s1[i] + "#" + s2[i]) && !pairSet.contains(s2[i] + "#" + s1[i])) return false;
    }
    return true;
}
```

**2. Anagram Check (Frequency Map)**
```java
/**
 * Algorithm: Return false if lengths differ. Increment char counts for s1, 
 * decrement for s2. Any non-zero count at the end means they aren't anagrams.
 */
public boolean isAnagram(String s, String t) {
    // Pattern: Frequency Map | Time: O(n), Space: O(1)
    if (s == null || t == null || s.length() != t.length()) return false; 
    int[] cnt = new int[256];
    for (char c : s.toCharArray())
        cnt[c]++;
    for (char c : t.toCharArray())
        if (--cnt[c] < 0) return false;
    return true;
}
```

**3. Two Sum (Hashing)**
```java
/**
 * Algorithm: Traverse the array once. For each number, calculate its 'complement' 
 * (target - x). Check if the complement exists in the map; if yes, return indices.
 * Otherwise, store current number and its index in the map.
 */
public int[] twoSum(int[] nums, int target) {
    // Pattern: Hashing | Time: O(n), Space: O(n)
    if (nums == null) throw new IllegalArgumentException(); 
    var map = java.util.HashMap.<Integer, Integer>newHashMap(nums.length);
    for (int i = 0; i < nums.length; i++) {
        Integer idx = map.get(target - nums[i]);
        if (idx != null) return new int[]{idx, i};
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException();
}
```
