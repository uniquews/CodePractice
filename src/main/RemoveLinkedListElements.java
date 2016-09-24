package main;

import main.utils.ListNode;

/**
 * Created by shuaiwang on 9/23/16.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
