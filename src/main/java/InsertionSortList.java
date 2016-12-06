import utils.ListNode;

/**
 * Created by shuaiwang on 9/25/16.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode nextCur = head.next;
            head.next = node.next;
            node.next = head;
            head = nextCur;
        }

        return dummy.next;
    }
}
