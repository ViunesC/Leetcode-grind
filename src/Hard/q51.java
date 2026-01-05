package Hard;

import java.util.ArrayList;
import java.util.List;

public class q51 {
    public static List<List<String>> result = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        List<String> chessboard = new ArrayList<>();
        StringBuilder column = new StringBuilder();

        column.append(".".repeat(Math.max(0, n)));

        for (int i=0;i<n;++i) {
            chessboard.add(column.toString());
        }

        backTrack(n,0,chessboard);
        return result;
    }

    private static void backTrack(int n, int row, List<String> chessboard) {
        if (row == n) {
            result.add(new ArrayList<>(chessboard));
            return;
        }

        StringBuilder col;
        String oldCol;
        for (int c=0;c<n;++c) {
            if (isValid(n, row, c, chessboard)) {
                oldCol = chessboard.get(row);
                col = new StringBuilder(oldCol);
                col.setCharAt(c,'Q');
                chessboard.set(row, col.toString());

                backTrack(n, row+1,chessboard);

                chessboard.set(row, oldCol);
            }
        }
    }

    private static boolean isValid(int n, int row, int col, List<String> chessboard) {
        // we only need to check if same col or diagonal has element
        for (int r=0;r<n;++r) {
            if (chessboard.get(r).charAt(col) == 'Q')
                // if there are queen(s) in same column
                return false;
        }

        int r=row-1, c=col-1;
        while (r >= 0 && c >= 0) {
            if (chessboard.get(r).charAt(c) == 'Q')
                return false;
            r--;
            c--;
        }

        r=row-1;
        c=col+1;
        while (r >= 0 && c < n) {
            if (chessboard.get(r).charAt(c) == 'Q')
                return false;
            r--;
            c++;
        }

        return true;
    }

    public static void testSample() {
        System.out.println(solveNQueens(4));
    }
}
