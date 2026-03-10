package Easy;

public class q459 {
    public static boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1)
            return false;

        // Assume repeated substring in s
        // Then if we create double s or s+s, then chop head and tail character (avoid matching entire s accidentally)
        // the rest of new string will contain at least one s
        // Since s is a periodic string
        String doubleS = (s + s).substring(1,s.length()*2-1);

        return in_str(doubleS, s) != -1;
    }

    private static int in_str(String haystack, String needle) {
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
        System.out.println(repeatedSubstringPattern("abab"));
    }
}
