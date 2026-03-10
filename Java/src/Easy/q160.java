package Easy;

public class q160 {
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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA), lenB = getLength(headB);

        int i;
        ListNode p,q;
        if (lenA > lenB) {
            i = lenA - lenB;
            p = headA;
            q = headB;
        } else {
            i = lenB - lenA;
            p = headB;
            q = headA;
        }

        while (i > 0) {
            p = p.next;
            --i;
        }

        while (p != null && q != null) {
            if (p == q)
                return p;
            p = p.next;
            q = q.next;
        }

        return null;
    }

    private int getLength(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            ++count;
            p = p.next;
        }

        return count;
    }

    public void testSample() {
        // Mo le
    }
}
