package Medium;

import java.util.*;

public class q406 {

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];   // a - b 是升序排列，故在a[0] == b[0]的狀況下，會根據k值升序排列
            return b[0] - a[0];   //b - a 是降序排列，在a[0] != b[0]，的狀況會根據h值降序排列
        });

        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1],p);   //Linkedlist.add(index, value)，會將value插入到指定index裡。
        }

        return que.toArray(new int[people.length][]);
    }

    public static void testSample() {
        int[][] people = new int[][] {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }
}
