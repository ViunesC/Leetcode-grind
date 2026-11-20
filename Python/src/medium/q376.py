import operator


class Solution:
    """
    Leetcode 376: Wiggle Subsequence
    """

    def wiggleMaxLength(self, nums: list[int]) -> int:
        if len(nums) == 1:
            return 1
        
        count = 0

        next_diff = None

        for i in range(1, len(nums)):
            if nums[i] == nums[i-1]:
                continue

            if next_diff == None or next_diff(nums[i], nums[i-1]):
                count += 1
                next_diff = operator.le if nums[i] > nums[i-1] else operator.ge
            
        return count + 1 # number of changes + 1 == number of elements in alternating sequencee


if __name__ == "__main__":
    sol = Solution()

    print(sol.wiggleMaxLength([1,4,4,4,3,2,1,7]))