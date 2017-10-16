import utils.ListNode;

/**
 * Created by shuaiwang on 9/21/16.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = reverse(slow.next);
        slow.next = null;
        ListNode first = head;

        while (second != null) {
            ListNode nextSecond = second.next;
            second.next = first.next;
            first.next = second;
            first = first.next.next;
            second = nextSecond;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prepare = new ListNode(-1);
        prepare.next = head;
        ListNode prev = head;
        ListNode cur = head.next;

        while (cur != null) {
            prev.next = cur.next;
            cur.next = prepare.next;
            prepare.next = cur;
            cur = prev.next;
        }
        return prepare.next;
    }
}
