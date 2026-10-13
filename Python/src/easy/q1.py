class Solution:
    """
    Leetcode 1: Two Sum
    """

    def twoSum(self, nums: list[int], target: int) -> list[int]:
        s = {}

        for i, n in enumerate(nums):
            s[n] = i

        for x_i, x in enumerate(nums):
            y_i = s.get(target-x, -1)

            if y_i != -1 and x_i != y_i:
                return [x_i, y_i]

        return [-1, -1]