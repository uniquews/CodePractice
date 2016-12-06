import utils.ListNode;

/**
 * Created by shuaiwang on 9/21/16.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }

    private ListNode findMiddle(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        ListNode slow = p;
        ListNode fast = p.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode p, ListNode q) {
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        while (p != null && q != null) {
            if (p.val < q.val) {
                result.next = p;
                p = p.next;
            } else {
                result.next = q;
                q = q.next;
            }
            result = result.next;
        }

        if (p != null) {
            result.next = p;
        }

        if (q != null) {
            result.next = q;
        }
        return dummy.next;
    }
}
