package main;

import main.utils.ListNode;

/**
 * Created by shuaiwang on 9/29/16.
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        int len = getLength(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prepare = dummy;

        for (int i = 0; i <= len - k; i = i + k) {
            prepare = reverse(prepare, k);
        }
        return dummy.next;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    private ListNode reverse(ListNode prepare, int k) {

        ListNode prev = prepare.next;
        ListNode cur = prepare.next.next;

        while (k > 1) {
            prev.next = cur.next;
            cur.next = prepare.next;
            prepare.next = cur;
            cur = prev.next;
            k--;
        }
        return prev;
    }
}
