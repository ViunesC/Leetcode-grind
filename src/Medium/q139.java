package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class q139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        boolean[] breakablePerLen = new boolean[s.length()+1];

        breakablePerLen[0] = true;

        // since it's a permutation question
        // we need to iterate backpack first before iterating word
        for (int i=1;i<=s.length();++i) {
            for (int j=0;j<i;++j) {
                if (dict.contains(s.substring(j, i)) && breakablePerLen[j]) {
                    // if [j,i] is a word from dict and substring with length of j is a word from dict
                    // then substring with length of i consist with words from dict
                    breakablePerLen[i] = true;
                    break;
                }
            }
        }

        return breakablePerLen[s.length()];
    }

    public static void testSample() {
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak("leetcode", dict));
    }
}
