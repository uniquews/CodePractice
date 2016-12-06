import utils.ListNode;

import java.util.HashSet;

/**
 * Created by shuaiwang on 9/23/16.
 */
public class RemoveDuplicatesfromUnsortedList {
    public ListNode removeDuplicates(ListNode head) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }

        HashSet s = new HashSet();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;

        while (p.next != null) {
            if (s.contains(p.next.val)) {
                s.add(p.next.val);
                p.next = p.next.next;
            } else {
                s.add(p.next.val);
                p = p.next;
            }
        }
        return dummy.next;
    }
}
