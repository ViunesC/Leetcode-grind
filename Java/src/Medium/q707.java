package Medium;

class MyLinkedList {
    private class Node {
        int val;
        Node next;
        Node() {this.next = null;}
        Node(int val) {this.val = val; next = null;}
    }

    private int size;
    private Node head;
    private Node tail;

    public MyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;

        Node p = head;
        for (int i=0;i<index;++i) {
            p = p.next;
        }

        return p.val;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);

        } else {
            Node temp = head;

            head = new Node(val);
            head.next = temp;
        }

        size++;

        if (tail == null)
            tail = head;
    }

    public void addAtTail(int val) {
        if (tail == null)
            addAtHead(val);
        else {
            Node temp = new Node(val);
            tail.next = temp;

            tail = temp;
            size++;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index > 0 && index < size) {
            Node p = head;
            Node temp;
            for (int i=0;i<index-1;++i) {
                p = p.next; // 0,1,2,3
            }

            temp = p.next;
            p.next = new Node(val);
            p.next.next = temp;
            size++;
        } else if (index == size)
            addAtTail(val);
        else if (index == 0)
            addAtHead(val);
    }

    public void deleteAtIndex(int index) {
        if (size == 0)
            return;

        if (index > 0 && index < size) {
            Node p = head;
            for (int i=0;i<index-1;++i) {
                p = p.next;
            }

            p.next = p.next.next;

            if (index == size-1)
                tail = p;
            size--;
        } else if (index == 0) {
            head = head.next;
            size--;
        }
    }

    @Override
    public String toString() {
        Node p = head;
        StringBuilder res = new StringBuilder();
        while (p != null) {
            res.append(p.val);

            if (p.next != null)
                res.append("=>");
            p = p.next;
        }

        return res.toString();
    }
}

public class q707 {
    public static void testSample() {
        MyLinkedList ll = new MyLinkedList();
        ll.addAtHead(7);
        ll.addAtHead(2);
        ll.addAtIndex(3,0);
        System.out.println(ll);
    }
}
