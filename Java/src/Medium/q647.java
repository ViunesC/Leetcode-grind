package Medium;

public class q647 {
    public static int countSubstrings(String s) {
        // dp[i][j]: true if s[i,j] is a palindrome
        // if s[i] != s[j], then false
        // if s[i] == s[j] and:
        // i = j, then it's a single char, hence true
        // j-i = 1, then it's a double char(e.g. aa), hence true
        // j-i > 1, then we need to check [i+1,j-1] => cabac, c=c, we check aba
        // initialize as all false
        boolean[][] dp = new boolean[s.length()][s.length()];

        int count = 0;
        for (int i=s.length()-1;i>=0;--i) {
            for (int j=i;j<s.length();++j) {
                // from bottom to top, from left to right
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }

    public static void testSample() {
        System.out.println(countSubstrings("aaa"));
    }
}
