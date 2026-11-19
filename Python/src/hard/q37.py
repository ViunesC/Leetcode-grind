class Solution:
    """
    Leetcode 37: Sudoku Solver
    """

    def solveSudoku(self, board: list[list[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.backTrack(board)

    def backTrack(self, board: list[list[str]]) -> bool:
        for r in range(len(board)):
            for c in range(len(board[0])):
                if board[r][c] != ".":
                    continue

                for d in range(1, 10):
                    if not self.isValid(board, str(d), r, c):
                        continue

                    board[r][c] = str(d)
                    
                    if self.backTrack(board):
                        return True
                    board[r][c] = "."

                return False

        return True


    def isValid(self, board: list[list[str]], digit, r, c) -> bool:
        # check row
        for cell_val in board[r]:
            if cell_val == digit:
                return False

        # check column
        for i in range(len(board)):
            if board[i][c] == digit:
                return False

        # check sub-box
        r_offset, c_offset = 1,1

        if r >= 6:
            r_offset = 3
        elif r >= 3:
            r_offset = 2

        if c >= 6:
            c_offset = 3
        elif c >= 3:
            c_offset = 2

        for i in range(3*r_offset-3, 3*r_offset):
            for j in range(3*c_offset-3, 3*c_offset):
                if board[i][j] == digit:
                    return False

        return True