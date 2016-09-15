package main;

import main.utils.ListNode;

/**
 * Created by shuaiwang on 9/14/16.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null) {
            return null;
        }

        ListNode dummy1 = new ListNode(-1);
        ListNode p = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode q = dummy2;

        while (head != null) {
            if (head.val < x) {
                dummy1.next = head;
                dummy1 = dummy1.next;
            } else {
                dummy2.next = head;
                dummy2 = dummy2.next;
            }
            head = head.next;
        }

        dummy1.next = q.next;
        dummy2.next = null;
        return p.next;
    }
}
