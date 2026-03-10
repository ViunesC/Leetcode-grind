package Medium;

import java.util.Arrays;

public class q151 {
    public static String reverseWords(String s) {
        s = s.trim();

        String[] parts = s.split("\s+");

        int left = 0, right = parts.length-1;
        String temp;
        while (left < right) {
            parts[left] = parts[left].trim();
            parts[right] = parts[right].trim();

            temp = parts[left];
            parts[left] = parts[right];
            parts[right] = temp;

            left++;
            right--;
        }

        StringBuilder builder = new StringBuilder();
        for (int i=0;i<parts.length;++i) {
            builder.append(parts[i]);

            if (i != parts.length-1)
                builder.append(" ");
        }

        return builder.toString();
    }

    public static String reverseWords2(String s) {
        s = removeExtraSpaces(s);

        StringBuffer resultBuffer = new StringBuffer(s);
        StringBuffer sub;
        resultBuffer.reverse();

        int slow=0, fast=0;
        while (slow < resultBuffer.length()) {
            while (fast < resultBuffer.length() && resultBuffer.charAt(fast) != ' ') {
                fast++;
            }

            sub = new StringBuffer(resultBuffer.substring(slow, fast)).reverse();
            resultBuffer.replace(slow, fast, sub.toString());

            fast++;
            slow = fast;
        }

        return resultBuffer.toString();
    }

    private static String removeExtraSpaces(String str) {
        char[] oldStr = str.toCharArray();

        int slow = 0;
        for (int fast=0;fast<str.length();++fast) {
            if (oldStr[fast] != ' ') {
                if (slow != 0)
                    oldStr[slow++] = ' ';
                while (fast < str.length() && oldStr[fast] != ' ')
                    oldStr[slow++] = oldStr[fast++];
            }
        }

        char[] newStr = new char[slow];
        System.arraycopy(oldStr, 0, newStr, 0, slow);

        return new String(newStr);
    }

    public static void testSample() {
        System.out.println(reverseWords2("sky is    blue! "));
    }
}
