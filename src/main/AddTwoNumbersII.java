package main;

import main.utils.ListNode;

/**
 * Created by shuaiwang on 9/28/16.
 */
public class AddTwoNumbersII {
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        l1 = reverse(l1);
        l2 = reverse(l2);
        return reverse(addTwoLinkedlist(l1, l2));
    }

    private ListNode reverse(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = p;
        ListNode prepare = dummy;
        ListNode prev = p;
        ListNode cur = p.next;

        while (cur != null) {
            prev.next = cur.next;
            cur.next = prepare.next;
            prepare.next = cur;
            cur = prev.next;
        }
        return dummy.next;
    }

    private ListNode addTwoLinkedlist(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        int nextPos = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + nextPos;
            ListNode cur = new ListNode(val % 10);
            nextPos = val / 10;
            prev.next = cur;
            prev = cur;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = l1.val + nextPos;
            ListNode cur = new ListNode(val % 10);
            prev.next = cur;
            prev = cur;
            nextPos = nextPos / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            int val = l2.val + nextPos;
            ListNode cur = new ListNode(val % 10);
            prev.next = cur;
            prev = cur;
            nextPos = nextPos / 10;
            l2 = l2.next;
        }

        if (nextPos != 0) {
            prev.next = new ListNode(nextPos);
        }
        return dummy.next;
    }
}
