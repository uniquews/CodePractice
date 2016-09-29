package main;

import main.utils.TreeNode;
import test.DoublyListNode;

import java.util.Stack;

/**
 * Created by shuaiwang on 9/28/16.
 */
public class ConvertBinarySearchTreetoDoublyLinkedList {
//    public DoublyListNode bstToDoublyList(TreeNode root) {
//        // Write your code here
//        DoublyListNode dummy = new DoublyListNode(-1);
//        DoublyListNode p = dummy;
//
//        Stack<TreeNode> stk = new Stack<TreeNode>();
//        TreeNode cur = root;
//        while (!stk.isEmpty() || cur != null) {
//            if (cur == null) {
//                TreeNode tmp = stk.pop();
//                DoublyListNode nextNode = new DoublyListNode(tmp.val);
//                p.next = nextNode;
//                nextNode.prev = p;
//                p = nextNode;
//                cur = tmp.right;
//            } else {
//                stk.push(cur);
//                cur = cur.left;
//            }
//        }
//        return dummy.next;
//    }
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // Write your code here
        DoublyListNode dummy = new DoublyListNode(-1);
        DoublyListNode p = dummy;

        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null) {
            if (cur.left == null) {
                DoublyListNode nextNode = new DoublyListNode(cur.val);
                p.next = nextNode;
                nextNode.prev = p;
                p = p.next;
                cur = cur.right;
            } else {
                prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    DoublyListNode nextNode = new DoublyListNode(cur.val);
                    p.next = nextNode;
                    nextNode.prev = p;
                    p = p.next;
                    cur = cur.right;
                }
            }
        }
        return dummy.next;
    }
}
