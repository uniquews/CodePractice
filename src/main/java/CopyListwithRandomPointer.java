import utils.RandomListNode;

/**
 * Created by shuaiwang on 9/20/16.
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode result = dummy;
        while (cur != null) {
            result.next = cur.next;
            cur.next = cur.next.next;
            result = result.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(-1);
        CopyListwithRandomPointer test = new CopyListwithRandomPointer();
        test.copyRandomList(a);
    }
}
