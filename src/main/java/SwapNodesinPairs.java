import utils.ListNode;

/**
 * Created by shuaiwang on 9/24/16.
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prepare = dummy;

        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }

        for (int i = 0; i < len - 1; i = i + 2) {
            prepare = reverse(prepare);
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode prepare) {
        ListNode prev = prepare.next;
        ListNode cur = prepare.next.next;

        prev.next = cur.next;
        cur.next = prepare.next;
        prepare.next = cur;
        return prev;
    }
}
