class Solution:
    """
    Leetcode 55: Jump Game
    """

    def canJump(self, nums: list[int]) -> bool:
        furthest_idx = 0

        for i in range(len(nums)):
            if i > furthest_idx:
                # not reachable
                return False

            furthest_idx = max(furthest_idx, i + nums[i])

        return True

if __name__ == "__main__":
    sol = Solution()
    print(sol.canJump([3,2,1,0,4]))