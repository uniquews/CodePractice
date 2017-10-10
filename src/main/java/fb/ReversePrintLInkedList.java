package fb;

import utils.ListNode;

public class ReversePrintLInkedList {
    public void reversePrint(ListNode head) {
        if (head == null) {
            return;
        }

        reversePrint(head.next);
        System.out.println(head.val + " ");
    }

    public static void main(String[] args) {
        ReversePrintLInkedList test = new ReversePrintLInkedList();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        test.reversePrint(a);
    }
}
