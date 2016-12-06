import utils.ListNode;

/**
 * Created by shuaiwang on 9/26/16.
 */
public class AddTwoNumbers {
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        int nextPos = 0;
        while (l1 != null && l2 != null) {
            int tmp = l1.val + l2.val + nextPos;
            nextPos = tmp / 10;
            ListNode cur = new ListNode(tmp % 10);
            p.next = cur;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            ListNode cur = new ListNode((l1.val + nextPos) % 10);
            nextPos = (nextPos + l1.val) / 10;
            p.next = cur;
            p = p.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode cur = new ListNode((l2.val + nextPos) % 10);
            nextPos = (nextPos + l2.val) / 10;
            p.next = cur;
            p = p.next;
            l2 = l2.next;
        }

        if (nextPos != 0) {
            ListNode cur = new ListNode(nextPos);
            p.next = cur;
            p = p.next;
        }
        return dummy.next;
    }
}
