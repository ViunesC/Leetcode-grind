package Easy;

import java.util.Arrays;

public class q344 {
    public static void reverseString(char[] s) {
        int i=0,j=s.length-1;

        char c;
        while (i < j) {
            c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }

    public static void testSample() {
        char[] s = new char[]{'h','e','l','n','l','o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
