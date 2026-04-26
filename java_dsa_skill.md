# Java DSA Mastery (FAANG/G-Level)

### 🎯 Core Persona: Platform Engineer / FAANG Sr. Developer
- **Efficiency First**: O(n) time, O(1) space, single-pass logic, and early exits.
- **Modern Java**: Use `var` (Java 10+), `HashMap.newHashMap(n)` (Java 19+), `map.merge()` (Java 8+), `Objects.requireNonNull`, `Deque` over `Stack`.
- **High Density**: Minimalist code, reduced line breaks, body on new line for readability.
- **Self-Documenting Structure**:
    1. **Class-Level**: Problem Name + Concise Problem Description.
    2. **Method-Level Javadoc**: `Algorithm:` block summarizing the logic.
    3. **Method-Level Marker**: The FIRST line inside each method must be a comment: `// Pattern: [Name] | Time: O(n), Space: O(1)`.
    4. **Inline Short-Comments**: Use brief, same-line comments for critical steps (e.g., `// Skip duplicates`, `// Sum too small`).
    5. **Post-Method FAANG Tip**: A single-line comment IMMEDIATELY after the method closing brace: `// FAANG Tip: [Interview talking points]`.

---

### 🛠 Prompt for Java Algorithms:
> "Optimize for FAANG/G standards. Maintain class-level problem description only. Method-level must include concise 'Algorithm:' block in Javadoc. The FIRST line inside each method must be a comment with 'Pattern: [Name] | Time: O(n), Space: O(1)'. Use brief inline comments for critical steps like duplicate skipping or pointer moves. Place '// FAANG Tip:' immediately after the method closing brace. Use modern Java (var, Deque, newHashMap). Maintain high code density."

---

### 🧩 Muscle Memory Patterns (Structured Density)

**1. Valid Parentheses (Deque / Mirror Matching)**
```java
/**
 * Problem: Valid Parentheses
 * Description: Check if an input string of brackets is valid and correctly ordered.
 */
public class Parentheses {
    /**
     * Algorithm: Traverse string once. Push expected closer onto Deque when opener seen.
     */
    public boolean isValid(String s) {
        // Pattern: Mirror Matching | Time: O(n), Space: O(n)
        if (s == null) return false;
        var stack = new ArrayDeque<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')'); // Push expected
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false; // Mismatch
        }
        return stack.isEmpty();
    }
    // FAANG Tip: Prefer Deque over Stack for thread-safety/performance. Mention O(n) space for unbalanced openers.
}
```

**2. Two Sum II (Two Pointers)**
```java
/**
 * Problem: Two Sum II - Sorted Array
 * Description: Find two numbers in a sorted array that add up to a specific target.
 */
public class TwoSum2 {
    /**
     * Algorithm: Use two pointers at extremes and move inward based on sum vs target.
     */
    public int[] twoSum(int[] nums, int target) {
        // Pattern: Two Pointers | Time: O(n), Space: O(1)
        var l = 0; var r = nums.length - 1;
        while (l < r) {
            var sum = nums[l] + nums[r];
            if (sum == target) return new int[]{l + 1, r + 1};
            if (sum < target) l++; else r--; // Shrink window
        }
        return new int[]{-1, -1};
    }
    // FAANG Tip: Sorted input allows O(1) space. Mention overflow checks if values exceed Integer.MAX_VALUE.
}
```

**3. 3Sum (Two Pointers + Deduplication)**
```java
/**
 * Problem: 3Sum
 * Description: Find all unique triplets that sum to zero.
 */
public class Three3Sum {
    /**
     * Algorithm: Sort and iterate 'i'. Use two pointers for remaining sum. Skip duplicates.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // Pattern: Two Pointers | Time: O(n^2), Space: O(1)
        Arrays.sort(nums); // Sort for pointers
        var res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicate i
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++; // Skip duplicate l
                    while (l < r && nums[r] == nums[r - 1]) r--; // Skip duplicate r
                    l++; r--;
                } else if (sum < 0) l++; else r--; // Adjust window
            }
        }
        return res;
    }
    // FAANG Tip: Duplicate skipping is crucial for O(n^2) without extra Set space. Sorting is O(n log n).
}
```
