package Easy;

public class q541 {
    public static String reverseStr(String s, int k) {
        char[] results = s.toCharArray();

        for (int i=0;i<s.length();i+=2*k) {
            if (i + k < s.length()) {
                reverseSegment(results, i, i + k-1);
            } else {
                reverseSegment(results,i, s.length()-1);
            }
        }

        return new String (results);
    }

    private static void reverseSegment(char[] chs, int startPos, int endPos) {
        char c;
        while (startPos < endPos) {
            c = chs[startPos];
            chs[startPos] = chs[endPos];
            chs[endPos] = c;
            startPos++;
            endPos--;
        }
    }

    public static void testSample() {
        System.out.println(reverseStr("abcdefg", 2));
        //StringBuffer b = new StringBuffer("abcd");
        //reverseSegment(b, 0, b.length()-1);
        //System.out.println(b.toString());
    }
}
