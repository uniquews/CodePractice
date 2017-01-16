import utils.ListNode;

/**
 * Created by shuaiwang on 1/15/17.
 */
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode newHead = reverse(head);
        ListNode afterPlusOne = plusHelper(newHead);
        return reverse(afterPlusOne);
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = head;
        ListNode cur = head.next;

        while (cur != null) {
            prev.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = prev.next;
        }
        return dummy.next;
    }

    private ListNode plusHelper(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        int plus = 1;
        while (plus != 0 && prev.next != null) {
            int value = (prev.next.val + plus);
            prev.next.val = value % 10;
            plus = value / 10;
            prev = prev.next;
        }

        if (plus != 0 && prev.next == null) {
            ListNode newHead = new ListNode(plus);
            prev.next = newHead;
        }
        return dummy.next;
    }
}
