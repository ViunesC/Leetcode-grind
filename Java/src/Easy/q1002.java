package Easy;

import java.util.ArrayList;
import java.util.List;

public class q1002 {
    public static List<String> commonChars(String[] words) {
        int[] hash = new int[26];
        int[] newHash;

        for (char c : words[0].toCharArray()) {
            hash[c - 'a']++;
        }

        for (int i=1;i<words.length;++i) {
            newHash = new int[26];

            for (char c : words[i].toCharArray()) {
                newHash[c - 'a']++;
            }

            for (int j=0;j<26;++j) {
                hash[j] = Math.min(hash[j], newHash[j]);
            }
        }

        List<String> result = new ArrayList<>();

        for (int i=0;i<26;++i) {
            for (int j=0;j<hash[i];++j) {
                result.add(String.valueOf((char) (i + 97)));
            }
        }

        return result;
    }

    public static void testSample() {
        System.out.println(commonChars(new String[]{"bella","label","roller"}));
    }
}
