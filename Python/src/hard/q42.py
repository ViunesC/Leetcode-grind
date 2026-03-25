from typing import List

class Solution:
    """
    Leetcode 42: Trapping rain water
    """

    def trap(self, height: List[int]) -> int:
        start, end = 0, len(height)-1
        leftMax, rightMax = 0, 0
        res = 0

        for i in range(len(height)):
            leftMax = max(leftMax, height[start]) # denotes highest pillar on left side
            rightMax = max(rightMax, height[end]) # denotes highest pillar on right side
            
            # we let the shorter side determines amount of water to be catched
            if leftMax < rightMax:
                res += leftMax
                start += 1
            else:
                res += rightMax
                end -= 1
            res -= height[i]

        return res