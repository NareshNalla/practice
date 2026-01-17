'''
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
'''
from typing import List

class RotateImage:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        
        # 1. Transpose the matrix (swap rows and columns)
        for i in range(n):
            for j in range(i, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        
        # 2. Reverse each row
        for i in range(n):
            matrix[i].reverse()

    def roatateNeet(self, matrix: List[List[int]]) -> None:
        l , r = 0, len(matrix) -1
        while l<r:
            for i in range( r - l):
                top , bottom = l , r
                #save the top left
                topLeft = matrix[top][l+i]

                #move bottom-left into top-left
                matrix[top][l+i] = matrix[bottom - i][l]

                #move bottom-right into bottom-left
                matrix[bottom - i][l] = matrix[bottom][r - i]

                #move top-right into bottom-right
                matrix[bottom ][r-i] = matrix[top+i][r]

                #move topleft into top-right
                matrix[top+i][r] = topLeft
            r -=1
            l +=1



if __name__ == "__main__":
    solution = RotateImage()
    
    # Test Case 1
    matrix1 = [[1,2,3],[4,5,6],[7,8,9]]
    print(f"Original: {matrix1}")
    solution.roatateNeet(matrix1)
    print(f"Rotated:  {matrix1}") # Expected: [[7,4,1],[8,5,2],[9,6,3]]
    print("-" * 20)

    # Test Case 2
    matrix2 = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
    print(f"Original: {matrix2}")
    solution.rotate(matrix2)
    print(f"Rotated:  {matrix2}") # Expected: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
