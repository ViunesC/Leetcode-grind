class Solution:
    """
    Leetcode 704: Binary search
    """

    def search(self, nums: list[int], target: int) -> int:
        left, right = 0, len(nums)-1

        while left <= right:
            mid = (right - left) // 2 + left

            if nums[mid] < target:
                left = mid+1
            elif nums[mid] > target:
                right = mid-1
            else:
                return mid

        return -1


if __name__ == "__main__":
    sol = Solution()
    print(sol.search([1,2,3,4,5], 9))