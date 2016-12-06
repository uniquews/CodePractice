import utils.ListNode;

/**
 * Created by shuaiwang on 9/25/16.
 */
public class DeleteNodeintheMiddleofSinglyLinkedList {
    public void deleteNode(ListNode node) {
        // write your code here
        if (node == null) {
            return;
        }

        ListNode nextNode = node.next;
        if (nextNode != null) {
            node.val = nextNode.val;
            node.next = nextNode.next;
        } else {
            node = null;
        }
        return;
    }

}
