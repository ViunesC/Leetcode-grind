package Medium;

public class q19 {
    // Fast-Slow Pointer

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        public String toString() { ListNode p = this; StringBuilder res = new StringBuilder(); while (p != null) {
            res.append(p.val);
            if (p.next != null) {
                res.append("->");
            }
            p = p.next;
        } return res.toString();}
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        if (head.next.next == null && n == 1) {
            head.next = null;
            return head;
        }

        // i for n+1-th nodes before j
        ListNode i = head,j = head;
        int count = n+1;

        while (j != null) {
            j = j.next;

            if (count <= 0)
                i = i.next;
            count--;
        }

        if (count > 0) {
            return head.next;
        }

        i.next = i.next.next;

        return head;
    }

    public void testSample() {
        ListNode head = new ListNode(1);
        ListNode m1 = new ListNode(2);
        ListNode m2 = new ListNode(3);

        m1.next = m2;
        head.next = m1;

        System.out.println(removeNthFromEnd(head, 2));
    }
}
