class Solution:
    """
    Leetcode 289: Game of Life
    """

    def gameOfLife(self, board: list[list[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        need_flipping = []

        neighbours = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]

        for r in range(len(board)):
            for c in range(len(board[0])):
                # calculate dead/alive neighbours
                dead_nb, alive_nb = 0,0

                for nb in neighbours:
                    if r + nb[0] < 0 or r + nb[0] >= len(board) or c + nb[1] < 0 or c + nb[1] >= len(board[0]):
                        continue

                    if board[r+nb[0]][c+nb[1]] == 0:
                        dead_nb += 1
                    else:
                        alive_nb += 1

                curr = board[r][c]

                # revival or death - both needs flipping
                if curr == 0 and alive_nb == 3 or curr == 1 and (alive_nb < 2 or alive_nb > 3):
                    need_flipping.append((r,c))

        for r,c in need_flipping:
            board[r][c] = 1 if board[r][c] == 0 else 0