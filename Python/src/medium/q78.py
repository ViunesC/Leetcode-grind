class Solution:
    """
    Leetcode 78: Subsets
    """
    path: list[int]
    results: list[list[int]]

    def subsets(self, nums: list[int]) -> list[list[int]]:
        self.path, self.results = [],[]

        for i in range(len(nums)+1):
            self.backTrack(nums,i,0)

        return self.results

    def backTrack(self, nums: list[int], k: int, start: int):
        if k == 0:
            self.results.append(self.path.copy())
            return

        for i in range(start, len(nums)):
            self.path.append(nums[i])
            self.backTrack(nums, k-1, i+1)
            self.path.pop()