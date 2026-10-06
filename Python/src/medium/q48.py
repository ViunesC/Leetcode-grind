from typing import List
from collections import deque

class Solution:
    """
    Leetcode 48: Rotate Image
    """

    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        next = deque()
        x_start, y_start = 0,0
        carry_over = -1

        while n > 1:
            x, y = x_start, y_start
            # init next to left side
            for i in range(n):
                next.append(matrix[x+(n-1-i)][y])

            # override top
            for i in range(n):
                next.append(matrix[x][y])
                carry_over = matrix[x][y] if i == n-1 else carry_over
                matrix[x][y] = next.popleft()

                if i != n-1:
                    y += 1

            # print("TOP", matrix)

            # right
            for i in range(n):
                next.append(matrix[x][y] if i > 0 else carry_over)
                carry_over = matrix[x][y] if i == n-1 else carry_over
                matrix[x][y] = next.popleft()

                if i != n-1:
                    x += 1
            
            # print("R", matrix)

            # bottom
            for i in range(n):
                next.append(matrix[x][y] if i > 0 else carry_over)
                matrix[x][y] = next.popleft()

                if i != n-1:
                    y -= 1

            # print("BTM", matrix)

            # left
            for i in range(n):
                matrix[x][y] = next.popleft()

                if i != n-1:
                    x -= 1

            # reset start pos, decrement n
            n -= 2
            x_start, y_start = x_start+1, y_start+1


if __name__ == "__main__":
    sol = Solution()
    m = [
        [1,2,3,4],
        [5,6,7,8],
        [9,10,11,12],
        [13,14,15,16]
    ]

    sol.rotate(m)

    print(m)