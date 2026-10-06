from typing import List

class Solution:
    """
    Leetcode 54: Spiral Matrix
    """

    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        # if not matrix:
        #     return []

        # rowStart, rowEnd = 0, len(matrix)-1
        # colStart, colEnd = 0, len(matrix[0])-1

        # results = []
        # while rowStart <= rowEnd and colStart <= colEnd:
        #     for j in range(colStart, colEnd+1):
        #         results.append(matrix[rowStart][j])
        #     rowStart += 1

        #     for i in range(rowStart, rowEnd+1):
        #         results.append(matrix[i][colEnd])
        #     colEnd -= 1

        #     if rowStart <= rowEnd:
        #         for j in range(colEnd, colStart-1, -1):
        #             results.append(matrix[rowEnd][j])
        #     rowEnd -= 1

        #     if colStart <= colEnd:
        #         for i in range(rowEnd, rowStart-1, -1):
        #             results.append(matrix[i][colStart])
        #     colStart += 1
            
        # return results
        x, y = 0, 0
        results = []

        while True:
            moved = False
            # rightward
            while y < len(matrix[0])-1 and matrix[x][y+1] != -101:
                results.append(matrix[x][y])
                matrix[x][y] = -101
                y += 1
                moved = True

            # downward
            while x < len(matrix)-1 and matrix[x+1][y] != -101:
                results.append(matrix[x][y])
                matrix[x][y] = -101
                x += 1
                moved = True

            # leftward
            while y > 0 and matrix[x][y-1] != -101:
                results.append(matrix[x][y])
                matrix[x][y] = -101
                y -= 1
                moved = True

            # upward
            while x > 0 and matrix[x-1][y] != -101:
                results.append(matrix[x][y])
                matrix[x][y] = -101
                x -= 1
                moved = True

            if not moved:
                break
        
        results.append(matrix[x][y])
        
        return results
    

if __name__ == "__main__":
    sol = Solution()

    # print(sol.spiralOrder(
    #     [
    #         [1,  2,  3,  4,  5],
    #         [14, 15, 16, 17, 6],
    #         [13, 20, 19, 18, 7],
    #         [12, 11, 10, 9,  8]
    #     ]
    # ))

    print(sol.spiralOrder(
        [
            [1, 2],
            [4, 3]
        ]
    ))