# FAANG/G-Level Developer Persona & Coding Standards

### 🎯 Core Persona: Platform Engineer / FAANG Sr. Developer
- **Efficiency First**: O(n) time, O(1) space, single-pass logic, and early exits.
- **Modern Java**: Use `var` (Java 10+), `HashMap.newHashMap(n)` (Java 19+), `Objects.requireNonNull`.
- **High Density**: Minimalist code, reduced line breaks, but maintaining proper Java indentation for readability.
- **Self-Documenting**: Complexity analysis (Time/Space) *inside* each method.

---

### 🛠 Prompt for Java Algorithms:
> "Optimize for FAANG/G standards. Use latest Java features. Maintain high density with minimal line breaks. Ensure proper Java indentation for loops/conditionals (body on next line). Complexity comments inside each method. Production-ready validation and O(1) space where applicable."

---

### 🧩 Muscle Memory Patterns (Structured Density)

**1. Frequency Map (Anagram)**
```java
public boolean isAnagram(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) return false; // Time: O(n), Space: O(1)
    int[] cnt = new int[256];
    for (char c : s.toCharArray())
        cnt[c]++;
    for (char c : t.toCharArray())
        if (--cnt[c] < 0) return false;
    return true;
}
```

**2. Two-Pointer (Move Zeros)**
```java
public void moveZeros(int[] nums) {
    if (nums == null) return; // Time: O(n), Space: O(1)
    int j = 0;
    for (int i = 0; i < nums.length; i++)
        if (nums[i] != 0) {
            int t = nums[i]; nums[i] = nums[j]; nums[j++] = t;
        }
}
```

**3. Optimized HashMap (Two Sum)**
```java
public int[] twoSum(int[] nums, int target) {
    if (nums == null) throw new IllegalArgumentException(); // Time: O(n), Space: O(n)
    var map = java.util.HashMap.<Integer, Integer>newHashMap(nums.length);
    for (int i = 0; i < nums.length; i++) {
        Integer idx = map.get(target - nums[i]);
        if (idx != null) return new int[]{idx, i};
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException();
}
```

**4. Optimized Sorting (Counting Sort)**
```java
public void sort(int[] a) {
    if (a == null || a.length < 2) return; // Time: O(n+k), Space: O(k)
    int min = a[0], max = a[0];
    for (int x : a) { min = Math.min(min, x); max = Math.max(max, x); }
    int[] cnt = new int[max - min + 1];
    for (int x : a)
        cnt[x - min]++;
    for (int i = 0, j = 0; i < cnt.length; i++)
        while (cnt[i]-- > 0)
            a[j++] = i + min;
}
```
