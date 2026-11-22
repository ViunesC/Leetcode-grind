class Solution:
    """
    Leetcode 977: Squares of a Sorted Array
    """

    def largestSumAfterKNegations(self, nums: list[int], k: int) -> int:
        nums.sort()

        i = 0
        while k > 0 and i < len(nums) and nums[i] < 0:
            # apply negation on negative elements once first
            nums[i] = -nums[i]
            i += 1
            k -= 1

        if k > 0:
            nums.sort()

            while k > 0:
                # apply negation on smallest element many timess
                nums[0] = -nums[0]
                k -= 1

        sum_arr = 0

        for n in nums:
            sum_arr += n

        return sum_arr
        