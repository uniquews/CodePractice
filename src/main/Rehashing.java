package main;

import main.utils.ListNode;

/**
 * Created by shuaiwang on 10/23/16.
 */
public class Rehashing {
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int capacity = hashTable.length * 2;
        ListNode[] result = new ListNode[capacity];

        for (int i = 0; i < hashTable.length; i++) {
            ListNode current = hashTable[i];
            while (current != null) {
                int number = current.val;
                int position = (number % capacity + capacity) % capacity;
                ListNode newNode = new ListNode(number);
                if (result[position] != null) {
                    ListNode dummy = result[position];
                    while (dummy.next != null) {
                        dummy = dummy.next;
                    }
                    dummy.next = newNode;
                } else {
                    result[position] = newNode;
                }
                current = current.next;
            }
        }
        return result;
    }
}
