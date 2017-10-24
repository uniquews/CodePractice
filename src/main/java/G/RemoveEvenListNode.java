package G;

import utils.DoublyListNode;

public class RemoveEvenListNode {
    public DoublyListNode removeEvenListNode(DoublyListNode head) {
        if (head == null) {
            return null;
        }
        DoublyListNode cur = head;
        DoublyListNode tail = head.prev;
        tail.next = null;
        head.prev = null;

        while (cur.next != null && cur.next.next != null) {
            DoublyListNode tmp = cur.next.next;
            cur.next = cur.next.next;
            tmp.prev = cur;
            cur = cur.next;
        }
        cur.next = head;
        head.prev = cur;
        return head;
    }

    public static void main(String[] args) {
        DoublyListNode a = new DoublyListNode(1);
        DoublyListNode b = new DoublyListNode(2);
        DoublyListNode c = new DoublyListNode(3);
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = a;
        a.prev = c;

//        DoublyListNode a = new DoublyListNode(1);a
//        DoublyListNode b = new DoublyListNode(2);
//        a.next = b;
//        a.prev = b;
//        b.prev = a;
//        b.next = a; 2


        RemoveEvenListNode test = new RemoveEvenListNode();
        DoublyListNode result = test.removeEvenListNode(a);
        return;
    }
}
