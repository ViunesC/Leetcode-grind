package Medium;

public class q142 {
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

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                // intersect at some node
                // start searching this node
                slow = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
