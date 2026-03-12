from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.results = []
        self.path = []

        for i in range(len(nums)):
            self.backTrack(0, i, nums)
        
        return self.results
    
    def backTrack(self, start: int, remaining: int, nums: List[int]):
        if remaining == 0:
            self.results.append(self.path.copy())
        
        for i in range(start, len(nums)):
            self.path.append(nums[i])
            self.backTrack(i+1, remaining-1, nums)
            self.path.pop()