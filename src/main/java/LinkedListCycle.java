import utils.ListNode;

/**
 * Created by shuaiwang on 9/29/16.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
