package Medium;

public class q474 {
    public static int findMaxForm(String[] strs, int m, int n) {
        // we can convert this problem into 0-1 knapsack problem
        // by setting 'weight' to two dimensions, i and j, s.t.
        // dp[i][j] = maximum size of subarray with i's 0 and j's 1
        // then we iterate through each element in strs, in which we iterate dp[i][j] with either
        // 1. pick strs[x], then we calculate dp[i-num of 0 in strs][j-num of 1 in strs]+1 (1 is strs[x], meaning we picked it)
        // 2. don't pick strs[x], then dp[i][j]
        // we pick max between two
        // also i is iterated from m to num of 0 in strs[x], same for j

        int[][] maxLen = new int[m+1][n+1];

        int numOfZeros, numOfOnes;

        maxLen[0][0] = 0;

        for (String x : strs) {
            numOfZeros = countCharInString('0', x);
            numOfOnes = countCharInString('1', x);

            for (int i=m;i>=numOfZeros;--i) {
                for (int j=n;j>=numOfOnes;--j) {
                    maxLen[i][j] = Math.max(maxLen[i][j], maxLen[i-numOfZeros][j-numOfOnes] + 1);
                }
            }
        }

        return maxLen[m][n];
    }

    private static int countCharInString(char c, String s) {
        int count = 0;
        for (int i=0;i<s.length();++i) {
            if (s.charAt(i) == c) count++;
        }

        return count;
    }

    public static void testSample() {
        System.out.println(findMaxForm(new String[]{"10","0001","111001","1","0"},5,3));
    }
}
