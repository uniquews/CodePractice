package main;

import main.utils.ListNode;

/**
 * Created by shuaiwang on 9/27/16.
 */
public class SwapTwoNodesinLinkedList {
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = null;
        ListNode k = null;


        while (p.next != null) {
            if (p.next.val == v1 || p.next.val == v2) {
                if (q == null) {
                    q = p;
                    p = p.next;
                    continue;
                } else {
                    k = p;
                }
            }

            p = p.next;
        }

        if (q == null || k == null) {
            return head;
        }

        if (q.next.next == k.next) {
            ListNode tmp = q.next;
            ListNode tmp2 = k.next;
            q.next = k.next;
            tmp.next = k.next.next;
            tmp2.next = tmp;
        } else {
            ListNode a = q.next.next;
            ListNode b = k.next.next;
            ListNode tmp = k.next;

            q.next.next = b;
            k.next.next = a;
            k.next = q.next;
            q.next = tmp;
        }
        return dummy.next;
    }
}
