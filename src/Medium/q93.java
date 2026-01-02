package Medium;

import java.util.ArrayList;
import java.util.List;

public class q93 {
    private static StringBuilder path = new StringBuilder();
    private static List<String> result = new ArrayList<>();

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12)
            return new ArrayList<>();

        backTrack(s, 0, 4);
        return result;
    }

    private static void backTrack(String s, int start, int remaining) {
        if (remaining == 1) {
            String lastPart = s.substring(start);
            if (isValidSegment(lastPart)) {
                // System.out.println("PATH:" + path.toString());
                path.append(lastPart);

                result.add(path.toString());

                path.delete(path.length()-lastPart.length(), path.length());
            }
            return;
        }

        String nextSegment;
        for (int i=start;i<s.length();++i) {
            nextSegment = s.substring(start, i+1);
            if (!isValidSegment(nextSegment))
                break;

            path.append(nextSegment);
            path.append(".");

            backTrack(s,i+1,remaining-1);

            path.deleteCharAt(path.length()-1);
            path.delete(path.length()-nextSegment.length(), path.length());
        }


    }

    private static boolean isValidSegment(String s) {
        if (s.isEmpty() || (s.charAt(0) == '0' && s.length() > 1))
            return false;

        // System.out.println("ISVALID: " + Integer.parseInt(s));
        return Integer.parseInt(s) <= 255;
    }

    public static void testSample() {
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
