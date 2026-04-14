from typing import List

class Solution:
    """
    Leetcode 27: Remove Element
    """

    def removeElement(self, nums: List[int], val: int) -> int:
        # we replace, from head of nums, every element with non-val element
        # in their sequence, thus effectively removing all vals
        num_of_vals = 0
        swap_at = 0 # next index to be replaced

        for i in range(len(nums)):
            if nums[i] == val:
                num_of_vals += 1
            else:
                nums[swap_at] = nums[i]
                swap_at += 1
        
        return len(nums) - num_of_vals


if __name__ == "__main__":
    sol = Solution()
    arr = [1, 2, 3, 4, 5]