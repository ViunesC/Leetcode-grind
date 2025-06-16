package Easy;

import java.util.Stack;

/**
 * Leetcode 1047: Remove all adjacent duplicates in the string
 * @author Viunec
 */
public class q1047 {
    public static String removeDuplicates(String s) {
        if (s.length() == 1)
            return s;

        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            if (!stack.isEmpty() && s.charAt(i)==stack.peek())
                stack.pop();
            else
                stack.push(s.charAt(i));
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }

    public static void testSample() {
        System.out.println(removeDuplicates("azxxzy"));
    }
}
