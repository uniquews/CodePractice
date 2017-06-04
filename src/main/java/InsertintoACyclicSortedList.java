import utils.ListNode;

/**
 * Created by shuaiwang on 2/9/17.
 */
public class InsertintoACyclicSortedList {
    /**
     * @param node a list node in the list
     * @param x    an integer
     * @return the inserted new list node
     */
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
            if (isCurrentTheLargestNode(current)
                    && isNewNodeTheLargestOrSmallest(current, x)) {
                break;
            }
            current = current.next;
        }

        result.next = current.next;
        current.next = result;
        return result;
    }

    private boolean isCurrentTheLargestNode(ListNode current) {
        return current.val > current.next.val;
    }

    private boolean isNewNodeTheLargestOrSmallest(ListNode current, int x) {
        return x >= current.val || x <= current.next.val;
    }
}
