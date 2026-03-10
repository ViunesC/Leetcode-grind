package Easy;

import java.util.HashMap;
import java.util.Map;

public class q383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> available_char = new HashMap<>();

        for (int i=0;i<magazine.length();++i)
            available_char.put(magazine.charAt(i), available_char.getOrDefault(magazine.charAt(i),0)+1);

        int k;
        char c;
        for (int i=0;i<ransomNote.length();++i) {
            c = ransomNote.charAt(i);

            if (!available_char.containsKey(c))
                return false;
            else {
                k = available_char.get(c);

                if (k == 1)
                    available_char.remove(c);
                else
                    available_char.put(c, k-1);
            }
        }

        return true;
    }

    public static void testSample() {
        System.out.println(canConstruct("aa","aab"));
    }
}
