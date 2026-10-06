class Solution:
    """
    Leetcode 977: Squares of a Sorted Array
    """

    def sortedSquares(self, nums: list[int]) -> list[int]:
        i, j, k = 0, len(nums)-1, len(nums)-1
        result = [0] * len(nums)

        while i <= j:
            if nums[i]**2 > nums[j]**2:
                result[k] = nums[i]**2
                i += 1
            else:
                result[k] = nums[j]**2
                j -= 1
            k -= 1

        return result


if __name__ == "__main__":
    sol = Solution()
    arr = [-4,-1,0,3,10]
    print(sol.sortedSquares(arr))