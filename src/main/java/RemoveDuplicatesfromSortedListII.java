import utils.ListNode;

/**
 * Created by shuaiwang on 9/16/16.
 */
public class RemoveDuplicatesfromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;

        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int tmp = p.next.val;
                while (p.next != null && p.next.val == tmp) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
