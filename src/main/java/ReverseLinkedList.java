import utils.ListNode;

/**
 * Created by shuaiwang on 9/27/16.
 */
public class ReverseLinkedList {
//    public ListNode reverse(ListNode head) {
//        // write your code here
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//
//        ListNode prepare = dummy;
//        ListNode prev = head;
//        ListNode cur = head.next;
//
//        while (cur != null) {
//            prev.next = cur.next;
//            cur.next = prepare.next;
//            prepare.next = cur;
//            cur = prev.next;
//        }
//        return prepare.next;
//    }

    // recursion
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        if (head == null)
            return dummy.next;
        recursion(dummy, head.next, head);
        return dummy.next;
    }

    private void recursion(ListNode dummy, ListNode cur, ListNode end) {
        if (cur == null) {
            return;
        }
        ListNode next = cur.next;
        end.next = next;
        cur.next = dummy.next;
        dummy.next = cur;
        recursion(dummy, next, end);
    }
}
