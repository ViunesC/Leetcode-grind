from typing import List

class Solution:
    """
    Leetcode 189: Rotate Array
    """

    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        split_at = k if k < len(nums) else k % len(nums)

        new_nums = nums[len(nums)-split_at:] + nums[:len(nums)-split_at]

        for i in range(len(new_nums)):
            nums[i] = new_nums[i]