package Easy;

public class q541 {
    public static String reverseStr(String s, int k) {
        StringBuffer resultBuffer = new StringBuffer(s);
        if (s.length() < k) {
            reverseSegment(resultBuffer, 0, s.length() - 1);
            return resultBuffer.toString();
        } else if (s.length() < 2*k) {
            reverseSegment(resultBuffer, 0, k);
            return resultBuffer.toString();
        }


        int start = 0, end = 0;

        while (end < s.length()) {
             if (end % 2*k == 0) {
                 // for every 2k characters
                 reverseSegment(resultBuffer, start, end - k);
                 start = end + 1;
             } else if (end == s.length()-1) {
                 if (end - start < k)
                     // less than k characters remaining
                     reverseSegment(resultBuffer, start, end);
                 else
                     reverseSegment(resultBuffer, start, start+k);
             }
             end++;
        }

        return resultBuffer.toString();
    }

    private static void reverseSegment(StringBuffer s, int startPos, int endPos) {
        String c;
        while (startPos < endPos) {
            c = String.valueOf(s.charAt(startPos));
            s.replace(startPos,startPos+1, s.substring(endPos,endPos+1));
            s.replace(endPos, endPos+1,c);
            startPos++;
            endPos--;
        }
    }

    public static void testSample() {
        // System.out.println(reverseStr("abcdefg", 2));
        StringBuffer b = new StringBuffer("abcd");
        reverseSegment(b, 0, b.length()-1);
        System.out.println(b.toString());
    }
}
