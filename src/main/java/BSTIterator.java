import utils.TreeNode;

import java.util.Stack;

/**
 * Created by shuaiwang on 8/16/16.
 */
public class BSTIterator {
//
//    Stack<TreeNode> stk = new Stack<>();
//    TreeNode current;
//
//    //@param root: The root of binary tree.
//    public BSTIterator(TreeNode root) {
//        // write your code here
//        current = root;
//    }
//
//    //@return: True if there has next node, or false
//    public boolean hasNext() {
//        // write your code here
//        return current != null || !stk.isEmpty();
//    }
//
//    //@return: return next node
//    public TreeNode next() {
//        // write your code here
//        while (current != null) {
//            stk.push(current);
//            current = current.left;
//        }
//
//        current = stk.pop();
//        TreeNode node = current;
//        current = current.right;
//        return node;
//    }

    Stack<TreeNode> stk;
    TreeNode current;
    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        current = root;
    }

    private TreeNode helper() {
        TreeNode result = null;
        while (!stk.isEmpty() || current != null) {
            if (current != null) {
                stk.push(current);
                current = current.left;
            } else {
                current = stk.pop();
                result = current;
                current = current.right;
                break;
            }
        }
        return result;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stk.isEmpty() || current != null;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode result = helper();
        return result.val;
    }
}
