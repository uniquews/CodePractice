import utils.ListNode;

/**
 * Created by shuaiwang on 9/22/16.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prepare = dummy;

        for (int i = 0; i < m - 1; i++) {
            prepare = prepare.next;
        }

        ListNode prev = prepare.next;
        ListNode cur = prepare.next.next;

        for (int i = m; i < n; i++) {
            prev.next = cur.next;
            cur.next = prepare.next;
            prepare.next = cur;
            cur = prev.next;
        }

        return dummy.next;
    }
}
