package main;

import main.utils.ListNode;

/**
 * Created by shuaiwang on 9/23/16.
 */
public class MiddleofLinkedList {
    public ListNode middleNode(ListNode head) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
