package Medium;

import java.util.ArrayList;
import java.util.List;

public class q131 {

    private static List<String> path = new ArrayList<>();
    private static List<List<String>> result = new ArrayList<>();

    public static List<List<String>> partition(String s) {
        backTrack(s, 0);
        return result;
    }

    private static void backTrack(String s, int start) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        String haystack;
        for (int i=start;i<s.length();++i) {
            haystack = s.substring(start, i+1);
            if (isPalindrome(haystack)) {
                path.add(haystack);
            } else {
                continue;
            }

            backTrack(s, i+1);
            path.remove(path.size()-1);
        }
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }

    public static void testSample() {
        System.out.println(partition("a"));
    }
}
