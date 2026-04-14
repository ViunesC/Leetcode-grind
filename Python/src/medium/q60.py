from typing import List

class Solution:
    """
    Leetcode 60: Remove Duplicates from Sorted Array II
    """

    def removeDuplicates(self, nums: List[int]) -> int:
        freq = {}
        num_duplicates_gt_2 = 0
        swap_at = 0

        for i in range(len(nums)):
            if freq.get(nums[i], 0) < 2:
                freq[nums[i]] = freq.get(nums[i], 0) + 1
                nums[swap_at] = nums[i]
                swap_at += 1
            else:
                num_duplicates_gt_2 += 1
        
        return len(nums) - num_duplicates_gt_2