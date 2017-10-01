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
    ListNode newHead;
    public ListNode reverseList(ListNode head) {
        helper(head);
        return newHead;
    }


    private ListNode helper(ListNode n) {
        if (n == null || n.next == null) {
            newHead = n;
            return n;
        }

        ListNode newTail = helper(n.next);
        n.next = null;
        newTail.next = n;
        return n;
    }
}
