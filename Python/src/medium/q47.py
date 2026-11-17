class Solution:
    """
    Leetcode 47: Permutations II
    """
    path: list[int]
    results: list[list[int]]
    visited: list[bool]

    def permuteUnique(self, nums: list[int]) -> list[list[int]]:
        nums.sort()
        self.path, self.results = [], []
        self.visited = [False] * len(nums)

        self.backTrack(nums)
        return self.results

    def backTrack(self, nums: list[int]):
        if len(self.path) == len(nums):
            self.results.append(self.path.copy())
            return

        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i-1] and not self.visited[i-1]:
                continue
            if self.visited[i]:
                continue

            self.path.append(nums[i])
            self.visited[i] = True
            self.backTrack(nums)

            self.path.pop()
            self.visited[i] = False


if __name__ == "__main__":
    sol = Solution()

    print(sol.permuteUnique([1,2,3]))