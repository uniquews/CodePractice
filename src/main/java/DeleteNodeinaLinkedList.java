import utils.ListNode;

/**
 * Created by shuaiwang on 6/21/17.
 */
public class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
