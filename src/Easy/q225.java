package Easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class q225 {
    // In-place version: every time call to pop() or top()
    // remove one element, then add it back to end of queue at a time
    // except for last element, which is what we want to return
    // depends on pop() or top(), we want to add the last element back or not

    private Queue<Integer> queueTemp;
    private Queue<Integer> queueProper;

    public q225() {
        queueTemp = new ArrayDeque<>();
        queueProper = new ArrayDeque<>();
    }

    public void push(int x) {
        queueProper.add(x);
    }

    public int pop() {
        return transferElements(true);
    }

    public int top() {
        return transferElements(false);
    }

    public boolean empty() {
        return queueProper.isEmpty();
    }

    private int transferElements(boolean deleteLast) {
        int temp;
        while (true) {
            temp = queueProper.remove();

            if (queueProper.isEmpty())
                break;

            queueTemp.add(temp);
        }

        while(!queueTemp.isEmpty())
            queueProper.add(queueTemp.remove());

        if (!deleteLast) {
            queueProper.add(temp);
        }

        return temp;
    }

    public static void testSample() {
        q225 myStack = new q225();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }
}
