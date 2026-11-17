class Solution:
    """
    Leetcode 491: Non-decreasing Subsequences
    """
    path: list[int]
    results: list[list[int]]

    def findSubsequences(self, nums: list[int]) -> list[list[int]]:
        self.path, self.results = [], []

        self.backTrack(nums, 0)

        return self.results

    def backTrack(self, nums: list[int], start:int):
        if len(self.path) >= 2:
            self.results.append(self.path.copy())

        used = [False] * 201 

        for i in range(start, len(nums)):
            if (self.path and nums[i] < self.path[-1]) or used[nums[i]+100]:
                continue

            used[nums[i]+100] = True # same-level de-duplicate

            self.path.append(nums[i])
            self.backTrack(nums, i+1)
            self.path.pop()



if __name__ == "__main__":
    sol = Solution()
    print(sol.findSubsequences([4,6,7,7]))