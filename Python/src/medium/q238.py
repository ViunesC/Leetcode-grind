from typing import List

class Solution:
    """
    Leetcode 238: Product of Array Except Self
    """

    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # O(n) space solution:

        # nums = [1,2,3,4]
        # rgt_product = [24,12,4,1] = rightmost is 1, rest is r[m] = r[m+1] * num[m+1]
        # lft_product = [1,1,2,6] = leftmost is 1, rest is l[m] = l[m-1] * num[m-1]
        # final = [24,12,8,6]
        # lft_prod = [1] + [0] * (len(nums)-1)
        # rgt_prod = [0] * (len(nums)-1) + [1]

        # for i in range(1, len(nums)):
        #     lft_prod[i] = lft_prod[i-1] * nums[i-1]
        # for j in range(len(nums)-2, -1, -1):
        #     rgt_prod[j] = rgt_prod[j+1] * nums[j+1]
        
        # result = []

        # for i in range(len(nums)):
        #     result.append(lft_prod[i]*rgt_prod[i])

        # O(1) space
        result = [1] * len(nums)
        product = 1

        for i in range(len(nums)):
            result[i] *= product
            product *= nums[i]
        
        product = 1
        for i in range(len(nums)-1, -1, -1):
            result[i] *= product
            product *= nums[i]

        return result