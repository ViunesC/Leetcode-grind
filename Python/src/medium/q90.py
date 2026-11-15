class Solution:
    """
    Leetcode 90: Subsets II
    """
    path: list[int]
    results: list[list[int]]

    def subsetsWithDup(self, nums: list[int]) -> list[list[int]]:
        nums.sort()
        self.path, self.results = [],[]
        used = [False]*len(nums)

        self.backTrack(nums,0, used)
        return self.results

    def backTrack(self, nums, start, used):
        self.results.append(self.path.copy())

        for i in range(start, len(nums)):
            if i > 0 and nums[i] == nums[i-1] and not used[i-1]:
                # it's not used meaning both number are not in same branch (path), so it's duplicate
                continue

            self.path.append(nums[i])
            used[i] = True
            self.backTrack(nums,i+1,used)
            used[i] = False
            self.path.pop()