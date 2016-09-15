package main;

import main.utils.ListNode;

/**
 * Created by shuaiwang on 9/14/16.
 */
public class RemoveNthNodeFromEndofList {
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;

        while (n > 0) {
            p = p.next;
            n--;
        }

        while (p.next != null) {
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;
        return dummy.next;
    }
}
