'''
Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
'''
from typing import List

class SpiralMatrix:
    """
    Time Complexity: O(M * N) - We visit every element exactly once.
    Space Complexity: O(1) - Excluding the output array.
    """
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        res = []
        left, right = 0, len(matrix[0])
        top, bottom = 0, len(matrix)

        while left < right and top < bottom:
            # 1. Traverse Top Row (left to right)
            for i in range(left, right):
                res.append(matrix[top][i])
            top += 1

            # 2. Traverse Right Column (top to bottom)
            for i in range(top, bottom):
                res.append(matrix[i][right - 1])
            right -= 1

            if not (left < right and top < bottom):
                break

            # 3. Traverse Bottom Row (right to left)
            for i in range(right - 1, left - 1, -1):
                res.append(matrix[bottom - 1][i])
            bottom -= 1

            # 4. Traverse Left Column (bottom to top)
            for i in range(bottom - 1, top - 1, -1):
                res.append(matrix[i][left])
            left += 1

        return res

if __name__ == "__main__":
    solution = SpiralMatrix()
    
    # Test Case 1
    matrix1 = [[1,2,3],[4,5,6],[7,8,9]]
    print(f"Input: {matrix1}")
    print(f"Output: {solution.spiralOrder(matrix1)}") # Expected: [1,2,3,6,9,8,7,4,5]
    print("-" * 20)

    # Test Case 2
    matrix2 = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    print(f"Input: {matrix2}")
    print(f"Output: {solution.spiralOrder(matrix2)}") # Expected: [1,2,3,4,8,12,11,10,9,5,6,7]
