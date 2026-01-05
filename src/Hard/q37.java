package Hard;

public class q37 {
    public static void solveSudoku(char[][] board) {
        backTrack(board);
    }

    private static boolean backTrack(char[][] board) {
        for (int r=0;r<board.length;++r) {
            for (int c=0;c<board[r].length;++c) {
                if (board[r][c] != '.')
                    continue;

                for (int i=1;i<10;++i) {
                    if (isValid(i,r,c,board)) {
                        board[r][c] = (char) (i + '0');
                        if (backTrack(board)) return true;
                        board[r][c] = '.';
                    }
                }

                // if there is no way to put any number between 1 and 9
                // means that this branch is dead, return false to cease exploration
                return false;
            }
        }

        // if the algorithm does not return false after searching through entire board
        // then we found a solution, return true
        return true;
    }

    private static boolean isValid(int val, int row, int col, char[][] board) {
        char charVal = (char) (val + '0');

        for (char[] chars : board) {
            if (chars[col] == charVal)
                return false;
        }

        for (int c=0;c<board[row].length;++c) {
            if (board[row][c] == charVal)
                return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int r=startRow;r<startRow+3;++r) {
            for (int c=startCol;c<startCol+3;++c) {
                if (board[r][c] == charVal)
                    return false;
            }
        }

        return true;
    }

    public static void testSample() {
    }
}
