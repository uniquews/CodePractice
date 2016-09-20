package main;

import main.utils.RandomListNode;

/**
 * Created by shuaiwang on 9/20/16.
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here

        if (head == null) {
            return null;
        }

        RandomListNode p = head;
        while (p != null) {
            RandomListNode newNode = new RandomListNode(p.label);
            newNode.next = p.next;
            p.next = newNode;
            p = p.next.next;
        }

        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        p = head;
        RandomListNode result = p.next;
        while (p != null) {
            RandomListNode newNode = p.next;
            p.next = newNode.next;
            if (newNode.next != null) {
                newNode.next = newNode.next.next;
            }
            p = p.next;
        }
        return result;
    }
}
