package Medium;

public class q343 {
    public static int integerBreak(int n) {
        int[] maxBreak = new int[n+1];

        maxBreak[2] = 1;
        for (int i=3;i<=n;++i) {
            for (int j=1;j<=i/2;++j) {
                // math definition: the largest product only appears when n was break into m subsets,
                // where m is smaller than (1/2)n
                // we then compare and pick maximum of:
                //      1. current maximum break of integer i
                //      2. (i-j) * j, which is when i was broke into 2 numbers j and i-j
                //      3. maximum break of (i-j) * j, which is when i was broke into 2 or more numbers, maxBreak(i-j) and j
                maxBreak[i] = Math.max(maxBreak[i], Math.max((i-j)*j,maxBreak[i-j]*j));
            }
        }

        return maxBreak[maxBreak.length-1];
    }

    public static void testSample() {
        System.out.println(integerBreak(10));
    }
}
