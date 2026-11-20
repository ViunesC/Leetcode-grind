class Solution:
    """
    Leetcode 53: Maximum Subarray
    """

    def maxSubArray(self, nums: list[int]) -> int:
        result = float('-inf')
        interval = 0

        for num in nums:
            interval += num

            if interval > result: # found a new max
                result = interval
            if interval < 0: # sum below zero, discard and recalculate starting next
                interval = 0

        return result