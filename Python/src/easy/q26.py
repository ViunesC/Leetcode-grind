from typing import List

class Solution:
    """
    Leetcode 26: Remove Duplicates from Sorted Array
    """

    def removeDuplicates(self, nums: List[int]) -> int:
        visited = set()
        swap_at = 0
        num_duplicates = 0

        for i in range(len(nums)):
            if nums[i] not in visited:
                visited.add(nums[i])
                nums[swap_at] = nums[i]
                swap_at += 1
            else:
                num_duplicates += 1
        
        return len(nums) - num_duplicates