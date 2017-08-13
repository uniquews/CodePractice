import utils.ListNode;

import java.util.Random;

/**
 * Created by shuaiwang on 1/22/17.
 *
 *
 * Alg: http://blog.jobbole.com/42550/
 */
public class LinkedListRandomNode {
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    Random rand;
    ListNode node;
    public LinkedListRandomNode(ListNode head) {
        node = head;
        rand = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int result = node.val;
        ListNode current = node;
        for (int i = 1; current != null; i++) {
            if (rand.nextInt(i) == i - 1) {
                result = current.val;
            }
            current = current.next;
        }
        return result;
    }
}
