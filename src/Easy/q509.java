package Easy;

public class q509 {
    public static int fib(int n) {
        /*
        recursive way (O(2^n))
        if (n == 1 || n == 0)
            return n;

        return fib(n-1) + fib(n-2);
        */

        // DP way (O(n))
        int[] fibResults = new int[n+1];

        for (int i=0;i<=n;++i) {
            fibResults[i] = (i == 0 || i == 1) ? i : fibResults[i-1] + fibResults[i-2];
        }

        return fibResults[n];
    }

    public static void testSample() {
        System.out.println(fib(4));
    }
}
