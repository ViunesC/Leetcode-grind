package Kama;

import java.util.*;

public class q127 {
    /*
     * 卡码网 127. 骑士的攻击
     * https://kamacoder.com/problempage.php?pid=1203
     */

    private static class Knight implements Comparable<Knight> {
        int g,h,f;
        int x, y;

        Knight(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void setSearchParams(int g, int h) {
            this.g = g;
            this.h = h;
            this.f = g + h;
        }

        @Override
        public int compareTo(Knight other) {
            return Integer.compare(this.f, other.f);
        }
    }

    private static final int[][] nav = {{1, 2}, {2,1}, {-1,2}, {2,-1}, {1,-2}, {-2,1}, {-1,-2}, {-2,-1}};

    private static void a_star(int a1, int a2, int b1, int b2) {
        PriorityQueue<Knight> pq = new PriorityQueue<>();

        Knight start = new Knight(a1,a2);
        start.setSearchParams(heuristic(start, a1, a2), heuristic(start, b1, b2));
        pq.add(start);

        int[][] pathLen = new int[1001][1001];
        Knight next;
        int nX, nY;
        while (!pq.isEmpty()) {
            next = pq.remove();

            if (next.x == b1 && next.y == b2)
                break;

            for (int i=0;i<8;++i) {
                nX = next.x + nav[i][0];
                nY = next.y + nav[i][1];

                if (nX < 1 || nX > 1000 || nY < 1 || nY > 1000)
                    continue;

                if (pathLen[nX][nY] == 0) {
                    // if (nX,nY) hasn't been reached, we assign it with current steps taken + 1
                    pathLen[nX][nY] = pathLen[next.x][next.y] + 1;
                    Knight k = new Knight(nX, nY);

                    // we will omit sqrting all together to improve arithmetic precision
                    k.setSearchParams(next.g+5, heuristic(k, b1, b2));

                    pq.add(k);
                }
            }
        }

        System.out.println(pathLen[b1][b2]);
    }

    private static int heuristic(Knight k, int x, int y) {
        return (k.x - x) * (k.x - x) + (k.y - y) * (k.y - y);
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int N = myScanner.nextInt();

        for (int i=0;i<N;++i) {
            a_star(myScanner.nextInt(),myScanner.nextInt(),myScanner.nextInt(),myScanner.nextInt());
        }

        myScanner.close();
    }
}
