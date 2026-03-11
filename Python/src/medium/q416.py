from typing import List

class Solution:
    """
    Leetcode 416: Partition Equal Subset Sum
    """

    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        if total % 2 != 0:
            return False
        
        dp = [False for _ in range(total // 2 + 1)] # dp[N], N = total / 2
        dp[0] = True

        for i in range(len(nums)):
            for j in range(len(dp)-1, -1, -1):
                if j >= nums[i]:
                    dp[j] = dp[j] or dp[j - nums[i]]
        
        return dp[len(dp)-1]