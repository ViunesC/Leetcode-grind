class Solution:
    """
    Leetcode 40: Combination Sum II
    """

    path: list[int]
    results: list[list[int]]

    def combinationSum2(self, candidates: list[int], target: int) -> list[list[int]]:
        # O(nlogn)
        candidates.sort()
        self.path = []
        self.results = []

        self.backTrack(candidates, 0, target)

        return self.results

    def backTrack(self, candidates, start, target):
        if target == 0:
            self.results.append(self.path.copy())
            return

        for i in range(start, len(candidates)):
            if i > start and candidates[i] == candidates[i-1]:
                continue
            elif candidates[i] > target:
                break

            self.path.append(candidates[i])
            self.backTrack(candidates, i+1, target-candidates[i])
            self.path.pop()
            