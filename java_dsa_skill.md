# Java DSA Mastery (FAANG/G-Level)

### 🎯 Core Persona: Platform Engineer / FAANG Sr. Developer
- **Efficiency First**: O(n) time, O(1) space, single-pass logic, and early exits.
- **Modern Java**: Use `var` (Java 10+), `HashMap.newHashMap(n)` (Java 19+), `map.merge()` (Java 8+), `Objects.requireNonNull`.
- **High Density**: Minimalist code, reduced line breaks, but **body always on a new line** for readability.
- **Self-Documenting**: Pattern Name and Complexity analysis MUST be the first comment line *inside* the method.

---

### 🛠 Prompt for Java Algorithms:
> "Optimize for FAANG/G standards. Use latest Java features like var and map.merge(). Maintain high density but ensure for-loops and if-statements have the body on a new line. The FIRST line inside each method must be a comment with 'Pattern: [Name] | Time: O(n), Space: O(1)'. Production-ready validation and O(1) space where applicable."

---

### 🧩 Muscle Memory Patterns (Structured Density)

**1. Anagram Check (Frequency Map)**
```java
public boolean isAnagram(String s, String t) {
    // Pattern: Frequency Map | Time: O(n), Space: O(1)
    if (s == null || t == null || s.length() != t.length()) return false; 
    int[] cnt = new int[256];
    for (char c : s.toCharArray())
        cnt[c]++;
    for (char c : t.toCharArray())
        if (--cnt[c] < 0)
            return false;
    return true;
}
```

**2. Two Sum (Hashing)**
```java
public int[] twoSum(int[] nums, int target) {
    // Pattern: Hashing | Time: O(n), Space: O(n)
    if (nums == null) throw new IllegalArgumentException(); 
    var map = java.util.HashMap.<Integer, Integer>newHashMap(nums.length);
    for (int i = 0; i < nums.length; i++) {
        Integer idx = map.get(target - nums[i]);
        if (idx != null)
            return new int[]{idx, i};
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException();
}
```

**3. Move Zeros (Two-Pointer)**
```java
public void moveZeros(int[] nums) {
    // Pattern: Two-Pointer | Time: O(n), Space: O(1)
    if (nums == null) return; 
    int j = 0;
    for (int i = 0; i < nums.length; i++)
        if (nums[i] != 0) {
            int t = nums[i]; nums[i] = nums[j]; nums[j++] = t;
        }
}
```

**4. Frequency Counting (Modern way)**
```java
public void countFrequency(int[] nums) {
    // Pattern: Frequency Hashing | Time: O(n), Space: O(n)
    var map = new java.util.HashMap<Integer, Integer>();
    for (int x : nums)
        map.merge(x, 1, Integer::sum);
}
```
