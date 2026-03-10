package Medium;

import java.util.Arrays;

public class q738 {
    public static int monotoneIncreasingDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();

        int start = digits.length;
        for (int i=digits.length-2;i>=0;i--) {
            if (digits[i] > digits[i+1]) {
                // if decreasing subsequence occurred
                // let front digit minus 1
                // and let tailing digit becomes 9
                // e.g. 343 -> 339
                digits[i]--;
                start = i+1;
            }
        }

        for (int i=start;i<digits.length;++i) {
            digits[i] = '9';
        }

        return Integer.parseInt(String.valueOf(digits));
    }

    public static void testSample() {
        // System.out.println(('1' - '0') + 1);
        System.out.println(monotoneIncreasingDigits(100));
    }
}
