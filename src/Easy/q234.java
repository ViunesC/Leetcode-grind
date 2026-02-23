package Easy;

public class q234 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        int frontLen = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            frontLen++;
            fast = fast.next.next;
        }

        slow = reverse(slow);

        ListNode p = head;
        for (int i=0;i<frontLen;++i) {
            if (p.val != slow.val)
                return false;

            p = p.next;
            slow = slow.next;
        }

        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null, curr=head;

        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void testSample() {
        System.out.println(isPalindrome(new ListNode(1, new ListNode(2))));
    }
}
