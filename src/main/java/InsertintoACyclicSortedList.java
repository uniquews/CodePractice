import utils.ListNode;

/**
 * Created by shuaiwang on 2/9/17.
 */
public class InsertintoACyclicSortedList {
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        ListNode result = new ListNode(x);
        if (node == null) {
            result.next = result;
            return result;
        }
        ListNode current = node.next;

        while (current != node) {
            if (current.val <= x && current.next.val >= x) {
                break;
            }
            current = current.next;
        }

        result.next = current.next;
        current.next = result;
        return result;
    }
}
