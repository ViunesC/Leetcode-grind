package Easy;

public class q392 {
    public static boolean isSubsequence(String s, String t) {
        if (t.length() < s.length())
            return false;

        int i=0,j=0;

        while (i < t.length() && j < s.length()) {
            if (s.charAt(j) == t.charAt(i))
                j++;
            i++;
        }

        return j == s.length();
    }

    public static void testSample() {
        System.out.println(isSubsequence("acd", "ahbgdc"));
    }
}
