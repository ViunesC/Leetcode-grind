package Hard;

import java.util.Arrays;

public class q135 {
    public static int candy(int[] ratings) {
        int[] assignment = new int[ratings.length];
        Arrays.fill(assignment, 1);

        for (int i=1;i<ratings.length;++i) {
            if (ratings[i] > ratings[i-1])
                // 1st pass: left to right, pick when right child > left child
                assignment[i] = assignment[i-1] + 1;
        }

        for (int i=ratings.length-2;i>=0;--i) {
            if (ratings[i] > ratings[i+1])
                // 2nd pass: right to left, pick when left child > right child
                // for those that are bigger than both left and right, compare and assign the biggest among two
                assignment[i] = Math.max(assignment[i+1] + 1, assignment[i]);
        }

        int sum = 0;
        for (int e : assignment) {
            sum += e;
        }

        return sum;
    }

    public static void testSample() {
        System.out.println(candy(new int[]{1,2,2}));
    }
}
