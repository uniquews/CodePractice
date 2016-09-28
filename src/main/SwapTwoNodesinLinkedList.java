package main;

import main.utils.ListNode;

/**
 * Created by shuaiwang on 9/27/16.
 */
public class SwapTwoNodesinLinkedList {
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode node1 = null;
        ListNode node2 = null;

        while (cur.next != null) {
            if (cur.next.val == v1 || cur.next.val == v2) {
                if (node1 == null) {
                    node1 = cur;
                    cur = cur.next;
                    continue;
                } else {
                    node2 = cur;
                }
            }
            cur = cur.next;
        }

        if (node1 == null || node2 == null) {
            return head;
        }

        swapHelper(node1, node2);
        return dummy.next;
    }

    private void swapHelper(ListNode node1, ListNode node2) {
        ListNode cur1 = node1.next;
        ListNode cur2 = node2.next;
        ListNode next1 = node1.next.next;
        ListNode next2 = node2.next.next;
        if (node1.next.next == node2.next) {
            cur1.next = next2;
            cur2.next = cur1;
            node1.next = cur2;
        } else {
            cur1.next = next2;
            cur2.next = next1;
            node1.next = cur2;
            node2.next = cur1;
        }
        return;
    }
}
