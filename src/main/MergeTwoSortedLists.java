package main;

import main.utils.ListNode;

/**
 * Created by shuaiwang on 9/27/16.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }

        if (l2 != null) {
            p.next = l2;
        }

        return dummy.next;
    }
}
