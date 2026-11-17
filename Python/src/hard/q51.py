class Solution:
    """
    Leetcode 51: N-Queens
    """
    path: list[list[str]]
    results: list[list[str]]

    def solveNQueens(self, n: int) -> list[list[str]]:
        self.path = [["."]*n for _ in range(n)]
        self.results = []

        self.backTrack(n, 0)
        return self.results

    def backTrack(self, n, row):
        if row == n:
            # reach bottom of chessboard, found valid config
            self.results.append(["".join(cell) for cell in self.path])
            return

        for c in range(n):
            if not self.isValid(row, c, n):
                continue

            self.path[row][c] = "Q"
            self.backTrack(n, row+1)
            self.path[row][c] = "."

    def isValid(self, r, c, n) -> bool:
        # check upper section

        for _r in range(r):
            # check vertical
            if self.path[_r][c] == "Q":
                return False

            # left diagonal
            if c-(r-_r) >= 0 and self.path[_r][c-(r-_r)] == "Q":
                return False

            # right diagonal
            if c+(r-_r) < n and self.path[_r][c+(r-_r)] == "Q":
                return False

        return True


if __name__ == "__main__":
    sol = Solution()
    print(sol.solveNQueens(4))