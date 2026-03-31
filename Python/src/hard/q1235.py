from typing import List
import bisect


class Solution:
    """
    Leetcode 1235: Maximum Profit in Job Scheduling
    """

    def jobScheduling(
        self, startTime: List[int], endTime: List[int], profit: List[int]
    ) -> int:
        jobs = sorted(zip(startTime, endTime, profit), key=lambda v: v[1])
        dp = [[0, 0]]
        for s, e, p in jobs:
            i = (
                bisect.bisect(dp, [s + 1]) - 1
            )  # binary search to find the largest profit we can make before s
            if dp[i][1] + p > dp[-1][1]:
                dp.append([e, dp[i][1] + p])
        return dp[-1][1]


if __name__ == "__main__":
    sol = Solution()
    print(sol.jobScheduling([1, 2, 3, 3], [3, 4, 5, 6], [50, 10, 40, 70]))
