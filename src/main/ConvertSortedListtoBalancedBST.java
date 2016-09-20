package main;

import main.utils.ListNode;
import main.utils.TreeNode;

/**
 * Created by shuaiwang on 9/19/16.
 */
public class ConvertSortedListtoBalancedBST {
    private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        current = head;
        int size = getLength(head);
        return helper(size);
    }

    private int getLength(ListNode p) {
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    private TreeNode helper(int size) {
        if (size == 0) {
            return null;
        }

        TreeNode leftNode = helper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode rightNode = helper(size - 1 - size / 2);
        root.left = leftNode;
        root.right = rightNode;

        return root;
    }
}
