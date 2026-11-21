class Solution:
    """
    Leetcode 45: Jump Game II
    """

    def jump(self, nums: list[int]) -> int:
        if len(nums) == 1:
            return 0

        curr_cover, next_cover = 0, 0
        min_jump = 0

        for i in range(len(nums)):
            next_cover = max(next_cover, i + nums[i])
            if next_cover >= len(nums)-1:
                break
            
            if i == curr_cover:
                min_jump += 1
                curr_cover = next_cover

        return min_jump + 1