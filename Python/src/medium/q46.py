class Solution:
    """
    Leetcode 46: Permutations
    """
    path: list[int]
    results: list[list[int]]
    used: list[bool]

    def permute(self, nums: list[int]) -> list[list[int]]:
        self.path, self.results = [],[]
        self.used = [False] * 21

        self.backTrack(nums)
        return self.results

    def backTrack(self, nums: list[int]):
        if len(self.path) == len(nums):
            self.results.append(self.path.copy())
            return

        for i in range(len(nums)):
            if self.used[nums[i]+10]:
                continue

            self.path.append(nums[i])
            self.used[nums[i]+10] = True

            self.backTrack(nums)
            self.path.pop()
            self.used[nums[i]+10] = False