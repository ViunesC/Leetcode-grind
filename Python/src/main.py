from typing import List

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        result = image

        if sr - 1 >= 0 and result[sr-1][sc] == result[sr][sc]:
            result = self.floodFill(result, sr-1, sc, color)
        if sr + 1 < len(image) and result[sr+1][sc] == result[sr][sc]:
            result = self.floodFill(result, sr+1, sc, color)
        if sc - 1 >= 0 and result[sr][sc-1] == result[sr][sc]:
            result = self.floodFill(result, sr, sc-1, color)
        if sc + 1 < len(image[0]) and result[sr][sc+1] == result[sr][sc]:
            result = self.floodFill(result, sr, sc+1, color)

        result[sr][sc] = color

        return result

mySolution = Solution()

print(mySolution.floodFill([[1,1,1],[1,1,0],[1,0,1]], 1, 1, 2))
