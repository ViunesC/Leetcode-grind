package Easy;

import java.util.Stack;

public class q20 {
    public static boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();

        for (int i=0;i<s.length();++i) {
            if (!brackets.isEmpty() && brackets.peek() == s.charAt(i)) {
                brackets.pop();
                continue;
            }

            switch (s.charAt(i)) {
                case '[':
                    brackets.push(']');
                    break;
                case '(':
                    brackets.push(')');
                    break;
                case '{':
                    brackets.push('}');
                    break;
                default:
                    return false;
            }
        }

        return brackets.isEmpty();
    }

    public static void testSample() {
        System.out.println(isValid("([)]"));
    }
}
