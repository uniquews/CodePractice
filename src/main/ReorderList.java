package main;

import main.utils.ListNode;

/**
 * Created by shuaiwang on 9/21/16.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        // write your code here
        if (head == null) {
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode p = reverse(mid.next);
        mid.next = null;
        head = merge(head, p);
    }

    private ListNode findMiddle(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }

        ListNode slow = p;
        ListNode fast = p.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode p) {
        ListNode newHead = null;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = newHead;
            newHead = p;
            p = tmp;
        }
        return newHead;
    }

    private ListNode merge(ListNode p, ListNode q) {
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        int index = 0;
        while (p != null && q != null) {
            if (index % 2 == 0) {
                result.next = p;
                p = p.next;
            } else {
                result.next = q;
                q = q.next;
            }
            result = result.next;
            index++;
        }

        if (p == null) {
            result.next = q;
        }
        if (q == null) {
            result.next = p;
        }
        return dummy.next;
    }
}
