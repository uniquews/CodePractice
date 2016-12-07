import utils.ListNode;

/**
 * Created by shuaiwang on 9/28/16.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = head;
        ListNode q = head;

        k = k % getLength(head);
        while (k > 0) {
            p = p.next;
            k--;
        }

        while (p.next != null) {
            p = p.next;
            q = q.next;
        }

        p.next = head;
        ListNode newHead = q.next;
        dummy.next = newHead;
        q.next = null;
        return dummy.next;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
