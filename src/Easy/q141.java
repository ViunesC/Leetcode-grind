package Easy;

public class q141 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
         next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow=head, fast=head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    public static void testSample() {

    }
}
