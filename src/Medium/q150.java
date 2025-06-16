package Medium;

import java.util.Stack;

/**
 * Leetcode 150: Evaluate Reverse Polish Notation
 * @author Viunec
 */
public class q150 {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int x,y = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    y =  stack.pop();
                    x = stack.pop();
                    stack.push(x - y);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    y =  stack.pop();
                    x = stack.pop();
                    stack.push( x / y);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void testSample() {
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }
}
