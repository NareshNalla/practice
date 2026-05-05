# Graph Problems - Main Methods & DSA Skill Implementation ✅

## Summary
All 13 graph problem files have been enhanced with **comprehensive main methods** featuring multiple test cases and proper DSA skill formatting.

---

## Files Updated with Main Methods

### 1. **NumberOfConnectedComponentsInAnUndirectedGraph.java**
- **Pattern:** Union-Find
- **Time:** O(V + Eα(V)), **Space:** O(V)
- **Test Cases:** 4
  - 2 Components, 1 Component, All Isolated, Single Node
- **Status:** ✅ ALL PASS

### 2. **CourseSchedule.java**
- **Pattern:** BFS (Topological Sort / Kahn's Algorithm)
- **Time:** O(V + E), **Space:** O(V + E)
- **Test Cases:** 4
  - Cycle Detection, Linear Dependencies, Complex Graphs, Single Course
- **Status:** ✅ ALL PASS

### 3. **CourseScheduleII.java**
- **Pattern:** BFS (Topological Sort / Kahn's Algorithm)
- **Time:** O(V + E), **Space:** O(V + E)
- **Test Cases:** 4
  - Valid Ordering, Complex Valid Ordering, Cycle/Invalid, No Prerequisites
- **Status:** ✅ ALL PASS

### 4. **GraphValidTree.java**
- **Pattern:** Union-Find
- **Time:** O(V + Eα(V)), **Space:** O(V)
- **Test Cases:** 4
  - Valid Tree, Cycle Exists, Too Few Edges, Single Node
- **Status:** ✅ ALL PASS

### 5. **MaxAreaOfIsland.java**
- **Pattern:** DFS (Area Calculation)
- **Time:** O(m × n), **Space:** O(m × n)
- **Test Cases:** 4
  - Multiple Islands, Single Large Island, No Islands, Full Island
- **Status:** ✅ ALL PASS

### 6. **NumberOfIslands.java**
- **Pattern:** DFS (Grid Traversal)
- **Time:** O(m × n), **Space:** O(m × n)
- **Test Cases:** 4
  - Multiple Islands, Single Island, All Water, Checkerboard Pattern
- **Status:** ✅ ALL PASS

### 7. **PacificAtlanticWaterFlow.java**
- **Pattern:** Multi-source DFS
- **Time:** O(m × n), **Space:** O(m × n)
- **Test Cases:** 4
  - Simple Grid, 1×1 Grid, All Border, High Corners
- **Status:** ✅ ALL PASS

### 8. **RedundantConnection.java**
- **Pattern:** Union-Find (Cycle Detection)
- **Time:** O(V + Eα(V)), **Space:** O(V)
- **Test Cases:** 4
  - Simple Redundant Edge, Self-Loop, Larger Graph, Last Edge
- **Status:** ✅ ALL PASS

### 9. **RottingOranges.java**
- **Pattern:** Multi-source BFS
- **Time:** O(m × n), **Space:** O(m × n)
- **Test Cases:** 4
  - All Rotten in Time, Already Rotten, All Can Rot, No Fresh
- **Status:** ✅ ALL PASS

### 10. **SurroundedRegions.java**
- **Pattern:** Boundary DFS
- **Time:** O(m × n), **Space:** O(m × n)
- **Test Cases:** 4
  - Surrounded Regions, Border O, All X, Single Cell
- **Status:** ✅ ALL PASS

### 11. **WallsAndGates.java**
- **Pattern:** Multi-source BFS
- **Time:** O(m × n), **Space:** O(m × n)
- **Test Cases:** 4
  - Simple Grid, Adjacent Gate, Multiple Gates, All Gates
- **Status:** ✅ ALL PASS

### 12. **WordLadder.java**
- **Pattern:** BFS (Shortest Path)
- **Time:** O(N × M²), **Space:** O(N × M)
- **Test Cases:** 4
  - Standard Word Ladder, End Not Found, One Step, No Path
- **Status:** ✅ ALL PASS

### 13. **CloneGraph.java**
- **Pattern:** DFS + HashMap
- **Time:** O(V + E), **Space:** O(V)
- **Test Cases:** 3
  - Connected Graph, Single Node, Null Graph
- **Status:** ✅ ALL PASS

---

## Key DSA Concepts Covered

### Patterns Used
1. **Union-Find:** NumberOfConnectedComponents, GraphValidTree, RedundantConnection
2. **DFS:** CloneGraph, MaxAreaOfIsland, NumberOfIslands, SurroundedRegions, PacificAtlanticWaterFlow
3. **BFS/Topological Sort:** CourseSchedule, CourseScheduleII, WordLadder
4. **Multi-source BFS:** RottingOranges, WallsAndGates

### Advanced Techniques
- Path Compression in Union-Find
- Grid Traversal & "Sinking" pattern
- Boundary-based DFS
- Multi-source BFS for minimum distance
- Topological Sort with Kahn's Algorithm
- Graph Cloning with cycle handling

---

## How to Run Tests

### Compile All Graph Problems
```bash
cd /Users/nareshnalla/develop/practice/practice
javac --release 26 -d target/classes src/main/java/com/naresh/a_dsalgo/graphs/problems/*.java
```

### Run Individual Tests
```bash
# Example: Run Number Of Islands
java -cp target/classes com.naresh.a_dsalgo.graphs.problems.NumberOfIslands

# Example: Run Course Schedule
java -cp target/classes com.naresh.a_dsalgo.graphs.problems.CourseSchedule
```

### Run All Tests at Once
```bash
for file in src/main/java/com/naresh/a_dsalgo/graphs/problems/*.java; do
    class_name=$(basename "$file" .java)
    echo "=== Testing $class_name ==="
    java -cp target/classes com.naresh.a_dsalgo.graphs.problems.$class_name
done
```

---

## Interview Tips (FAANG Level)

### Cycle Detection Strategies
- **Union-Find:** Best for undirected graphs (O(n log n))
- **DFS with Color Tracking:** For directed graphs (3 states: white, gray, black)

### Multi-source BFS
- Perfect for "minimum time" or "nearest cell" problems
- Initialize queue with all source nodes (gates, rotten oranges, etc.)

### Grid Traversal Patterns
- **In-place modification:** Avoids extra space for visited tracking
- **Boundary DFS:** Process borders first to identify "escape" regions

### Topological Sort
- **Kahn's Algorithm (BFS):** Better for returning actual order
- **DFS-based:** Better for cycle detection in directed graphs

---

## Test Results Summary

```
✅ NumberOfConnectedComponentsInAnUndirectedGraph: 4/4 PASS
✅ CourseSchedule: 4/4 PASS
✅ CourseScheduleII: 4/4 PASS
✅ GraphValidTree: 4/4 PASS
✅ MaxAreaOfIsland: 4/4 PASS
✅ NumberOfIslands: 4/4 PASS
✅ PacificAtlanticWaterFlow: 4/4 PASS
✅ RedundantConnection: 4/4 PASS
✅ RottingOranges: 4/4 PASS
✅ SurroundedRegions: 4/4 PASS
✅ WallsAndGates: 4/4 PASS
✅ WordLadder: 4/4 PASS
✅ CloneGraph: 3/3 PASS

TOTAL: 51/51 TEST CASES PASSED ✅
```

---

## Next Steps for Interview Prep

1. ✅ Master pattern recognition for each graph type
2. ✅ Understand time/space complexity trade-offs
3. ✅ Practice explaining DFS vs BFS choice
4. ✅ Know Union-Find path compression optimization
5. ✅ Be ready to discuss cycle detection strategies
6. ✅ Explain multi-source BFS advantage over single-source

**You're now interview-ready for FAANG graph problems! 🚀**

