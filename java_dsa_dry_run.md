# Java DSA Dry Run Skill

### 🎯 Goal: Automated Dry Run Documentation
Generate a clear, step-by-step dry run of the algorithm and append it to the bottom of the source file as a Javadoc comment.

### 📝 Instructions for Dry Run Generation:
1. **Trace with Example**: Use the input from the `main` method (if present) or a standard representative example.
2. **Step-by-Step Breakdown**:
    - **Initialization**: Show initial values of pointers, result arrays, and counters.
    - **Loop Iterations**: Document each significant step inside loops (index, current value, state changes).
    - **State Transitions**: Explicitly show how variables like `preFix`, `postFix`, `sum`, or pointers change.
3. **Format**:
    - Place the dry run at the very end of the `.java` file.
    - Wrap it in a Javadoc block (`/** ... */`).
    - Use clear headings (e.g., `1. Initialization`, `2. First Pass`).
    - Use fixed-width style for arrays (e.g., `[1, 2, 3]`).

### 🚫 Instructions to Avoid:
- **NO Redundant Code**: Do not re-print the source code in the dry run comment.
- **NO Massive Files**: Keep the dry run concise. If the array is long, dry run only the first 3-4 and last 1-2 elements.
- **NO Implementation Changes**: Never modify the algorithm itself while adding the dry run.
- **NO Console Output Capture**: The dry run should be a manual mental trace of the logic, not just a copy of `System.out.println`.

### 🧩 Example Output Format (Appended to file):

```java
/**
 * Dry Run:
 * Input: nums = {1, 2, 3, 4}
 *
 * 1. Initialization:
 *    n = 4, res = [0, 0, 0, 0], preFix = 1
 *
 * 2. First Pass (Prefix Products):
 *    i = 0: res[0] = 1, preFix = 1
 *    ... (etc)
 *
 * 3. Result: [24, 12, 8, 6]
 */
```
