'''
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
'''
from typing import List

class SetMatrixZeroes:
    """
    Time Complexity: O(M * N)
    Space Complexity: O(1) - Using the first row and col as markers.
    """
    def setZeroes(self, matrix: List[List[int]]) -> None:
        ROWS, COLS = len(matrix), len(matrix[0])
        rowZero = False

        # 1. Determine which rows/cols need to be zeroed
        for r in range(ROWS):
            for c in range(COLS):
                if matrix[r][c] == 0:
                    matrix[0][c] = 0
                    if r > 0:
                        matrix[r][0] = 0
                    else:
                        rowZero = True

        # 2. Zero out cells based on markers (excluding first row/col)
        for r in range(1, ROWS):
            for c in range(1, COLS):
                if matrix[0][c] == 0 or matrix[r][0] == 0:
                    matrix[r][c] = 0

        # 3. Zero out first column if needed
        if matrix[0][0] == 0:
            for r in range(ROWS):
                matrix[r][0] = 0

        # 4. Zero out first row if needed
        if rowZero:
            for c in range(COLS):
                matrix[0][c] = 0

if __name__ == "__main__":
    solution = SetMatrixZeroes()
    
    # Test Case 1
    matrix1 = [[1,1,1],[1,0,1],[1,1,1]]
    print(f"Original: {matrix1}")
    solution.setZeroes(matrix1)
    print(f"Zeroed:   {matrix1}") # Expected: [[1,0,1],[0,0,0],[1,0,1]]
    print("-" * 20)

    # Test Case 2
    matrix2 = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
    print(f"Original: {matrix2}")
    solution.setZeroes(matrix2)
    print(f"Zeroed:   {matrix2}") # Expected: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
