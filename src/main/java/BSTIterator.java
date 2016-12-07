import utils.TreeNode;

import java.util.Stack;

/**
 * Created by shuaiwang on 8/16/16.
 */
public class BSTIterator {

    Stack<TreeNode> stk = new Stack<>();
    TreeNode current;

    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        // write your code here
        current = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return current != null || !stk.isEmpty();
    }

    //@return: return next node
    public TreeNode next() {
        // write your code here
        while (current != null) {
            stk.push(current);
            current = current.left;
        }

        current = stk.pop();
        TreeNode node = current;
        current = current.right;
        return node;
    }
}
