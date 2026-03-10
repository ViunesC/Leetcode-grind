package Medium;


import java.util.ArrayDeque;
import java.util.Deque;

public class q143 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void reorderList(ListNode head) {
        Deque<ListNode> queue = new ArrayDeque<>();

        ListNode p = head.next;

        while (p != null) {
            queue.push(p);
            p = p.next;
        }

        ListNode newHead = head;
        int count = 0;

        while (!queue.isEmpty()) {
            if (count % 2 == 0)
                newHead.next = queue.pop();
            else
                newHead.next = queue.removeLast();

            newHead = newHead.next;
            count++;
        }

        newHead.next = null;
    }

    public static void testSample() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        reorderList(head);

        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
