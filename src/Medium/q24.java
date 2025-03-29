package Medium;

import Easy.q206;

public class q24 {
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

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;


        ListNode prv = null, nxt = head.next.next;
        ListNode n1 = head, n2 = head.next, temp;
        boolean is_finished = false;
        while (!is_finished) {
            temp = n2;
            n2 = n1;
            n1 = temp;

            n1.next = n2;

            if (prv == null) {
                head = n1;
            } else {
                prv.next = n1;
            }

            n2.next = nxt;

            // Move pointer
            prv = n2;

            for (int i=0;i<2;++i) {
                if (n2 == null || n1 == null) {
                    is_finished = true;
                    break;
                }
                n2 = n2.next;
                n1 = n1.next;
            }

            if (n2 != null || n1 == null)
                nxt = n2.next;
            else
                is_finished = true;
        }

        return head;
    }

    public void testSample() {
        ListNode head = new ListNode(1);
        ListNode m1 = new ListNode(2);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(4);

        m2.next = m3;
        m1.next = m2;
        head.next = m1;

        System.out.println(swapPairs(head));
    }
}
