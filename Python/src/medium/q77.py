class Solution:
    """
    Leetcode 77: Combinations
    """

    path: list[int]
    results: list[list[int]]

    def combine(self, n: int, k: int) -> list[list[int]]:
        self.path = []
        self.results = []

        self.backTrack(1,n,k)

        return self.results

    def backTrack(self, start:int, n:int, k:int):
        if k == 0:
            self.results.append(self.path.copy())
            return

        for i in range(start, n+1):
            self.path.append(i)
            self.backTrack(i+1,n,k-1)
            self.path.pop()