import utils.ListNode;

/**
 * Created by shuaiwang on 9/29/16.
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prepare = dummy;
        while (prepare.next != null) {
            prepare = helper(prepare, k);
        }
        return dummy.next;
    }

    private int getLen(ListNode n, int k) {
        int len = 0;
        while (n != null && len < k) {
            len++;
            n = n.next;
        }
        return len;
    }

    private ListNode helper(ListNode n, int k) {
        if (getLen(n.next, k) < k) {
            return n.next;
        }
        ListNode prepare = n;
        ListNode prev = n.next;
        ListNode cur = n.next.next;
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
