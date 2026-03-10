package Kama;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class q104 {
    /*
     * 卡码网 104. 建造最大岛屿
     * https://kamacoder.com/problempage.php?pid=1176
     */

    private static int[][] nav = {{0,-1},{-1,0},{0,1},{1,0}};

    private static int dfs(int[][] map, int x, int y, boolean[][] visited, int index) {

        int r,c, area=1;
        for (int i=0;i<4;++i) {
            r = x + nav[i][0];
            c = y + nav[i][1];

            if (r < 0 || r >= map.length || c < 0 || c >= map[0].length)
                continue;

            if (map[r][c] == 1 && !visited[r][c]) {
                map[r][c] = index;
                visited[r][c] = true;
                area += dfs(map, r, c, visited, index);
            }
        }

        return area;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int N = myScanner.nextInt();
        int M = myScanner.nextInt();

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Map<Integer, Integer> areaOfIsland = new HashMap<>();
        int nextIndex = 2;

        for (int i=0;i<N;++i) {
            for (int j=0;j<M;++j) {
                map[i][j] = myScanner.nextInt();
            }
        }

        boolean isAllIsland = true;
        for (int i=0;i<N;++i) {
            for (int j=0;j<M;++j) {
                if (map[i][j] == 0)
                    isAllIsland = false;

                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    map[i][j] = nextIndex;
                    areaOfIsland.put(nextIndex, dfs(map, i, j, visited, nextIndex));
                    nextIndex++;
                }
            }
        }


        if (isAllIsland) {
            System.out.println(N*M);
            return;
        }

        int maxArea=1, currArea, r, c;
        Set<Integer> counted = new HashSet<>();
        for (int i=0;i<N;++i) {
            for (int j=0;j<M;++j) {
                currArea = 1;
                counted.clear();
                if (map[i][j] == 0) {
                    for (int k=0;k<4;++k) {
                        r = i + nav[k][0];
                        c = j + nav[k][1];

                        if (r < 0 || r >= map.length || c < 0 || c >= map[0].length)
                            continue;

                        if (map[r][c] > 1 && !counted.contains(map[r][c])) {
                            // System.out.println("getting " + map[r][c]);
                            currArea += areaOfIsland.get(map[r][c]);
                            counted.add(map[r][c]);
                        }
                    }
                }

                maxArea = Math.max(maxArea, currArea);
                // System.out.println("i:" + i + " j:" + j + " max:" + maxArea + " curr:" + currArea);
            }
        }

        System.out.println(maxArea);
    }
}
