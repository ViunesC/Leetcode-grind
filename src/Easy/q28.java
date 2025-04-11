package Easy;

import java.util.Arrays;

public class q28 {
    public static int strStr(String haystack, String needle) {
        //Brute-force
        int i=0,j=0;

        if (needle.equals(""))
            return 0;

        for (;i<haystack.length();++i) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                while (j < needle.length()) {
                    if (i >= haystack.length() || haystack.charAt(i) != needle.charAt(j))
                        break;
                    i++;
                    j++;
                }
                if (j == needle.length())
                    return i-j;
                else {
                    i -= j;
                    j = 0;
                }
            }
        }

        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        //O(m+n) KMP algorithm version
        int i=0,j=0;

        if (needle.isEmpty())
            return 0;

        // Generate next array
        int[] next = getNext(needle);

        for (;i<haystack.length();++i) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j))
                // if it does not match, rollback j
                // according to next[]
                j = next[j - 1];

            if (haystack.charAt(i) == needle.charAt(j))
                j++;

            if (j == needle.length())
                return i - needle.length() + 1;
        }

        return -1;
    }

    private static int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = 0;

        int j=0; // j for prefix
        for (int i=1;i<needle.length();++i) { // i for postfix
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                // prefix != postfix, rollback j
                j = next[j-1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                // prefix == postfix, increment j (maxlen + 1)
                j++;
            }
            next[i] = j;
        }

        return next;
    }

    public static void testSample() {
        System.out.println(strStr2("leetcode", "leet"));
//        System.out.println(Arrays.toString(getNext("a")));
//        System.out.println(Arrays.toString(getNext("aa")));
//        System.out.println(Arrays.toString(getNext("aab")));
//        System.out.println(Arrays.toString(getNext("aaba")));
//        System.out.println(Arrays.toString(getNext("aabaa")));
//        System.out.println(Arrays.toString(getNext("aabaaf")));
    }
}
