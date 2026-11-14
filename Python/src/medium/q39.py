class Solution:
    """
    Leetcode 39: Combination Sum
    """

    path: list[int]
    results: list[list[int]]

    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        self.path = []
        self.results = []
        
        self.backTrack(candidates, 0, target)
        return self.results

    def backTrack(self, candidates, start, target):
        if target == 0:
            self.results.append(self.path.copy())
            return

        for i in range(start, len(candidates)):
            if candidates[i] > target:
                continue
            
            self.path.append(candidates[i])
            self.backTrack(candidates, i, target-candidates[i])
            self.path.pop()