class Solution:
    """
    Leetcode 209: Minimum Size Subarray Sum
    """
    def minSubArrayLen(self, target: int, nums: list[int]) -> int:
        slow = 0
        min_len = len(nums) + 1

        interv_sum = 0
        for fast in range(len(nums)):
            interv_sum += nums[fast]

            while interv_sum >= target:
                min_len = min(min_len, fast - slow + 1)
                interv_sum -= nums[slow]
                slow += 1

        return min_len if min_len != len(nums) + 1 else 0


if __name__ == "__main__":
    sol = Solution()
    print(sol.minSubArrayLen(7, [2,3,1,2,4,3]))
