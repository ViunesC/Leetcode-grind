from typing import List

class Solution:
    """
    Leetcode 15: 3Sum
    """

    def threeSum(self, nums: list[int]) -> list[list[int]]:
        nums.sort() # O(nlogn)
        result = []

        for i in range(len(nums)): # O(n)
            if i > 0 and nums[i] == nums[i-1]:
                continue

            j, k = i+1, len(nums)-1

            while j < k: # O(n)
                t_sum = nums[i] + nums[j] + nums[k]

                if t_sum > 0:
                    k -= 1
                elif t_sum < 0:
                    j += 1
                else:
                    result.append([nums[i], nums[j], nums[k]])
                    j += 1
                    while nums[j] == nums[j-1] and j < k:
                        j += 1
        
        return result
    

if __name__ == "__main__":
    sol = Solution()
    print(sol.threeSum([0,0,0,0]))