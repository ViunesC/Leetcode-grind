class Solution:
    """
    Leetcode 209: Minimum Size Subarray Sum
    """

    def _sum(self, arr: list[int]) -> int:
        res = 0
        for v in arr:
            res += v

        return res

    def minSubArrayLen(self, target: int, nums: list[int]) -> int:
        slow, fast, min_len = 0,0, len(nums)+1

        while fast < len(nums):
            total = self._sum(nums[slow:fast+1])

            if total < target:
                fast += 1
            elif total > target:
                slow += 1
            else:
                min_len = min(min_len, fast - slow + 1)
                fast += 1

        if min_len == len(nums)+1:
            return 0
        else:
            return min_len


if __name__ == "__main__":
    sol = Solution()
    print(sol.minSubArrayLen(9, [1,4,4]))