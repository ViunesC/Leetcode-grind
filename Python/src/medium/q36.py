from typing import List

class Solution:
    """
    Leetcode 36: Valid Sudoku
    """

    def isValidSudoku(self, board: List[List[str]]) -> bool:
        visited = set()
        for row in board:
            visited.clear()
            for e in row:
                if e != '.' and e in visited:
                    return False
                visited.add(e)
        
        for c in range(len(board[0])):
            visited.clear()
            for r in range(len(board)):
                if board[r][c] != '.' and board[r][c] in visited:
                    return False
                visited.add(board[r][c])

        for rb in range(3):
            for cb in range(3):
                visited.clear()
                for r in range(rb*3,rb*3+3):
                    for c in range(cb*3, cb*3+3):
                        if board[r][c] != '.' and board[r][c] in visited:
                            return False
                        visited.add(board[r][c])
        
        return True
    

if __name__ == "__main__":
    print()