# Java DSA Mastery (FAANG/G-Level)

### 🎯 Core Persona: Platform Engineer / FAANG Sr. Developer
- **Efficiency First**: O(n) time, O(1) space, single-pass logic, and early exits.
- **Modern Java**: Use `var` (Java 10+), `HashMap.newHashMap(n)` (Java 19+), `map.merge()` (Java 8+), `Objects.requireNonNull`, `Deque` over `Stack`.
- **High Density**: Minimalist code, reduced line breaks, body on new line for readability.
- **Self-Documenting Structure**:
    1. **Class-Level**: Problem Name + Concise Problem Description (No strategy here).
    2. **Method-Level Javadoc**: 'Algorithm' block explaining the step-by-step logic.
    3. **Method-Level Marker**: The FIRST line inside each method must be a comment with: `// Pattern: [Name] | Time: O(n), Space: O(1)`.

---

### 🛠 Prompt for Java Algorithms:
> "Optimize for FAANG/G standards. Maintain class-level problem description only. Method-level must include a concise 'Algorithm:' block in Javadoc. The FIRST line inside each method must be a comment with 'Pattern: [Name] | Time: O(n), Space: O(1)'. Use modern Java (var, Deque, newHashMap). Maintain high code density."

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
     * Algorithm: Traverse the string once. For opening brackets, push the EXPECTED 
     * closer onto a Deque. For closing brackets, pop and verify equality.
     */
    public boolean isValid(String s) {
        // Pattern: Mirror Matching | Time: O(n), Space: O(n)
        if (s == null) return false;
        var stack = new ArrayDeque<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}
```

**2. Two Sum (Hashing)**
```java
/**
 * Problem: Two Sum
 * Description: Find indices of two numbers in an array that add up to a specific target.
 */
public class TwoSum {
    /**
     * Algorithm: Traverse array while calculating the required complement for each value.
     * Check Map for complement index; if missing, store current value and index.
     */
    public int[] twoSum(int[] nums, int target) {
        // Pattern: Hashing | Time: O(n), Space: O(n)
        if (nums == null) throw new IllegalArgumentException(); 
        var map = java.util.HashMap.<Integer, Integer>newHashMap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            var idx = map.get(target - nums[i]);
            if (idx != null) return new int[]{idx, i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }
}
```
