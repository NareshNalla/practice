'''
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

Input: m = 3, n = 7
Output: 28

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
'''

class UniquePaths:
    def uniquePaths(self, m: int, n: int) -> int:
        # Initialize the bottom row with 1s
        # This represents that there is only 1 way to reach the end from any cell in the last row (by going right)
        row = [1] * n
        
        # Iterate from the second to last row up to the top row
        # We run this m-1 times because the last row is already initialized
        for i in range(m - 1):
            newRow = [1] * n
            # Iterate from right to left, starting from the second to last column
            # The last column is always 1 (can only go down)
            for j in range(n - 2, -1, -1):
                # The number of ways to reach the end from (i, j) is:
                # Ways from the right cell (newRow[j+1]) + Ways from the cell below (row[j])
                newRow[j] = newRow[j+1] + row[j]
            row = newRow
            
        return row[0]
        # Time Complexity: O(m * n)
        # Space Complexity: O(n) - we only store one row

if __name__ == "__main__":
    solution = UniquePaths()
    
    # Test Case 1
    m1, n1 = 3, 7
    print(f"Unique Paths for {m1}x{n1}: {solution.uniquePaths(m1, n1)}") # Expected: 28

    # Test Case 2
    m2, n2 = 3, 2
    print(f"Unique Paths for {m2}x{n2}: {solution.uniquePaths(m2, n2)}") # Expected: 3
    
    # Test Case 3
    m3, n3 = 7, 3
    print(f"Unique Paths for {m3}x{n3}: {solution.uniquePaths(m3, n3)}") # Expected: 28
    
    # Test Case 4
    m4, n4 = 3, 3
    print(f"Unique Paths for {m4}x{n4}: {solution.uniquePaths(m4, n4)}") # Expected: 6
