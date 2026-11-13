class Solution:
    """
    Leetcode 216: Combination Sum III
    """

    path: list[int]
    results: list[list[int]]

    def combinationSum3(self, k: int, n: int) -> list[list[int]]:
        self.path = []
        self.results = []

        self.backTrack(k,n,1)

        return self.results

    def backTrack(self, k, n, start):
        if k == 0 and n == 0:
            self.results.append(self.path.copy())
            return

        for i in range(start, 10):
            if n < i:
                break
            elif k == 1 and i < n:
                continue

            self.path.append(i)
            self.backTrack(k-1, n-i, i+1)
            self.path.pop()