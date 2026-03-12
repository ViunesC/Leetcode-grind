from typing import List

class Solution:
    """
    Leetcode 54: Spiral Matrix
    """

    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        if not matrix:
            return []

        rowStart, rowEnd = 0, len(matrix)-1
        colStart, colEnd = 0, len(matrix[0])-1

        results = []
        while rowStart <= rowEnd and colStart <= colEnd:
            for j in range(colStart, colEnd+1):
                results.append(matrix[rowStart][j])
            rowStart += 1

            for i in range(rowStart, rowEnd+1):
                results.append(matrix[i][colEnd])
            colEnd -= 1

            if rowStart <= rowEnd:
                for j in range(colEnd, colStart-1, -1):
                    results.append(matrix[rowEnd][j])
            rowEnd -= 1

            if colStart <= colEnd:
                for i in range(rowEnd, rowStart-1, -1):
                    results.append(matrix[i][colStart])
            colStart += 1
            
        return results