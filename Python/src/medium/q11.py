from typing import List

class Solution:
    """
    Leetcode 11: Container With Most Water
    """

    def maxArea(self, height: List[int]) -> int:
        i, j = 0, len(height)-1

        maxAmount = 0
        while i < j:
            width = j - i
            amount = width * min(height[i], height[j])

            maxAmount = max(maxAmount, amount)
            
            # move pointer on the shorter end
            if height[i] > height[j]:
                j -= 1
            elif height[i] < height[j]:
                i += 1
            else:
                i += 1
                j -= 1
        
        return maxAmount