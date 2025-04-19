package Easy;

import java.util.ArrayDeque;
import java.util.Stack;

public class q232 {
    private Stack<Integer> stack_rev;
    private Stack<Integer> stack_seq;

    public q232() {
        this.stack_rev = new Stack<>();
        this.stack_seq = new Stack<>();
    }

    public void push(int x) {
        stack_rev.push(x);
    }

    public int pop() {
        if (stack_seq.empty())
            backFill();

        if (!empty())
            return stack_seq.pop();

        return -1;
    }

    public int peek() {
        if (stack_seq.empty())
            backFill();

        if (!empty())
            return stack_seq.peek();

        return -1;
    }

    public boolean empty() {
        return stack_rev.isEmpty() && stack_seq.isEmpty();
    }

    private void backFill() {
        while(!stack_rev.isEmpty())
            stack_seq.push(stack_rev.pop());
    }

    public static void testSample() {
        q232 my232 = new q232();
        my232.push(1); // queue is: [1]
        my232.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(my232.peek()); // return 1
        System.out.println(my232.pop()); // return 1, queue is [2]
        System.out.println(my232.empty()); // return false
    }
}
