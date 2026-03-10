package Easy;

public class q206 {
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

    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode temp, prev = null;
        if (head == null || p.next == null)
            // 0 or 1 node in the list
            return head;
        else if (p.next.next == null) {
            // 2 nodes in the list
            temp = p.next;
            temp.next = p;
            p.next = prev;
            return temp;
        }

        while (p.next != null) {
            // 3 or more nodes
            temp = p.next;
            p.next = prev;

            prev = p;
            p = temp;
        }
        p.next = prev;

        return p;
    }

    public void testSample() {
        ListNode head = new ListNode(1);
        ListNode m1 = new ListNode(2);
        // ListNode m2 = new ListNode(3);
        // ListNode m3 = new ListNode(4);

        // m2.next = m3;
        // m1.next = m2;
        head.next = m1;

        System.out.println(reverseList(head));
    }
}
