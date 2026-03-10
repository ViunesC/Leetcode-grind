from typing import List

class Solution:
    """
    Leetcode 75: Sort Colors
    """

    def sortColors(self, nums: List[int]) -> None:
        # we count number of 0, 1 and 2 in nums
        # then replace the array with 0 first, then 1, then 2
        zeros, ones, twos = 0, 0, 0
        for num in nums:
            if num == 0:
                zeros += 1
            elif num == 1:
                ones += 1
            else:
                twos += 1

        for i in range(len(nums)):
            if i < zeros:
                nums[i] = 0
            elif i < zeros + ones:
                nums[i] = 1
            else:
                nums[i] = 2
