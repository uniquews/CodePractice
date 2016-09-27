package main;

import main.utils.ListNode;

/**
 * Created by shuaiwang on 9/27/16.
 */
public class NthtoLastNodeinList {
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n - 1; i++) {
            p = p.next;
        }

        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
