package main;

import main.utils.ListNode;

/**
 * Created by shuaiwang on 9/27/16.
 */
public class RemoveDuplicatesfromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        ListNode result = head;
        while (head != null) {
            ListNode tmp = head.next;
            while (tmp != null && tmp.val == head.val) {
                tmp = tmp.next;
                head.next = tmp;
            }
            head = tmp;
        }
        return result;
    }
}
