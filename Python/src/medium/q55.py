from typing import List

class Solution:
    """
    Leetcode 55: Jump Game
    """

    def canJump(self, nums: List[int]) -> bool:
        coverage = 0

        for n in nums:
            if coverage < 0: # if coverage is depleted and got no supply in last cell, we cannot reach current and future cells, return false
                return False
            elif n > coverage: # if current cell has a coverage > current coverage, replace current
                coverage = n
            coverage -= 1 # each time subtract 1 when moving forward
        
        return True
    

if __name__ == "__main__":
    sol = Solution()
    print(sol.canJump([3,2,1,0,4]))