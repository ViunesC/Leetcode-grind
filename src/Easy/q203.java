package Easy;

public class q203 {
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

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;

        ListNode h = head;
        ListNode temp;

        while(h != null && h.val == val) {
            h = h.next;
        }

        ListNode p = h;

        while (p != null) {
            if (p.next != null && p.next.val == val) {
                while (p.next != null && p.next.val == val)
                    p.next = p.next.next;
            }

            p = p.next;
        }

        return h;
    }

    public void testSample() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);
        ListNode g = new ListNode(6);

        f.next = g;
        e.next = f;
        d.next = e;
        c.next = d;
        b.next = c;
        a.next = b;

        System.out.println(removeElements(a,6));
    }
}
