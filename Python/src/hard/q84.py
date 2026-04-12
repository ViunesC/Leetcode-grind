from typing import List
from collections import deque

class Solution:
    """
    Leetcode 84: Largest Rectangle in Histogram
    """

    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = deque([0])
        heights = [0] + heights + [0] # pad 0s for monotonic decreasing stack, and force pop at the end
        result = 0

        for i in range(len(heights)):
            if heights[i] > heights[stack[-1]]: # next > top, pushing into the stack
                stack.append(i)
            elif heights[i] == heights[stack[-1]]:
                stack.pop()
                stack.append(i)
            else: # next < top, poping and calculating max area
                while stack and heights[i] < heights[stack[-1]]:
                    mid = stack.pop()
                    right = i

                    if stack:
                        left = stack[-1]
                        w = right - left - 1 # exclude left and right, we only calculate what's in between
                        h = heights[mid]
                        result = max(result, w*h)
                stack.append(i)
        
        return result