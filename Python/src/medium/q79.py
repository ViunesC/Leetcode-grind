from typing import List

class Solution:
    """
    Leetcode 79: Word Search
    """

    def exist(self, board: List[List[str]], word: str) -> bool:
        self.nav = [[0, 1], [1, 0], [0, -1], [-1, 0]]

        for r in range(len(board)):
            for c in range(len(board[0])):
                if self.dfs(board, r, c, word):
                    return True

        return False

    def dfs(self, board, x, y, word) -> bool:
        if len(word) == 0:
            return True # found the word
        
        if x < 0 or x >= len(board) or y < 0 or y >= len(board[0]) or board[x][y] != word[0]:
            return False
        
        board[x][y] = "#" # avoid searching again
        res = False
        for i in range(4):
            nx = x + self.nav[i][0]
            ny = y + self.nav[i][1]

            res = res or self.dfs(board, nx, ny, word[1:])

        board[x][y] = word[0]
        return res
        


if __name__ == "__main__":
    sol = Solution()

    board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
    word = "ABC"

    print(sol.exist(board, word))