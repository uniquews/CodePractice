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
    private ListNode head;
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode current = head;
        int result = current.val;
        current = current.next;
        for (int i = 2; current != null; i++) {
            if (generateRandom(i) == i - 1) {
                result = current.val;
            }
        }
        return result;
    }

    private int generateRandom(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
}
