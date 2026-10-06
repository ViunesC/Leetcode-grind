from typing import List

class Solution:
    """
    Leetcode 45: Jump Game II
    """

    def jump(self, nums: List[int]) -> int:
        jumps, curr_furthest, next_furthest = 0,0,0

        for i, num in enumerate(nums):
            next_furthest = max(next_furthest, i + num)

            if i == curr_furthest and i != len(nums)-1:
                jumps += 1
                curr_furthest = next_furthest
        
        return jumps