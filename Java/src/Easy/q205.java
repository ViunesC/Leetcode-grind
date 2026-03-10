package Easy;

import java.util.HashMap;
import java.util.Map;

public class q205 {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();

        Character s1, t1;
        for (int i=0;i<s.length();++i) {
            s1 = t2s.getOrDefault(t.charAt(i), null);
            t1 = s2t.getOrDefault(s.charAt(i), null);

            if (s1 == null)
                t2s.put(t.charAt(i), s.charAt(i));
            if (t1 == null)
                s2t.put(s.charAt(i), t.charAt(i));

            if (s2t.get(s.charAt(i)) != t.charAt(i) || t2s.get(t.charAt(i)) != s.charAt(i))
                return false;
        }

        return true;
    }

    public static void testSample() {
        System.out.println(isIsomorphic("badc", "baba"));
    }
}
