package Easy;

public class q70 {
    public static int climbStairs(int n) {
        // each entry represent # of ways to reach this entry from 0
        int[] ways = new int[n];

        for (int i=0;i<n;++i) {
            switch(i) {
                case 0:
                    ways[i] = 1;
                    break;
                case 1:
                    ways[i] = 2;
                    break;
                default:
                    ways[i] = ways[i-1] + ways[i-2];
                    break;
            }
        }

        return ways[n-1];
    }

    public static void testSample() {
        System.out.println(climbStairs(3));
    }
}
