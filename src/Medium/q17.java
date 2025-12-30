package Medium;

import java.util.ArrayList;
import java.util.List;

public class q17 {
    private static StringBuilder path = new StringBuilder();
    private static List<String> result = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        backTrack(digits,0);
        return result;
    }

    private static void backTrack(String digits, int start) {
        if (start == digits.length()) {
            result.add(path.toString());
            return;
        }

        char[] charMapping = switch (digits.charAt(start)) {
            case '2' -> new char[]{'a', 'b', 'c'};
            case '3' -> new char[]{'d', 'e', 'f'};
            case '4' -> new char[]{'g', 'h', 'i'};
            case '5' -> new char[]{'j', 'k', 'l'};
            case '6' -> new char[]{'m', 'n', 'o'};
            case '7' -> new char[]{'p', 'q', 'r', 's'};
            case '8' -> new char[]{'t', 'u', 'v'};
            case '9' -> new char[]{'w', 'x', 'y', 'z'};
            default -> new char[0];
        };

        for (char c : charMapping) {
            path.append(c);
            backTrack(digits, start+1);
            path.deleteCharAt(path.length()-1);
        }
    }

    public static void testSample() {
        System.out.println(letterCombinations("67"));
    }
}
