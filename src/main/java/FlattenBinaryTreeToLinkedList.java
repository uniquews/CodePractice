import utils.TreeNode;

import java.util.Stack;

/**
 * Created by shuaiwang on 2/5/17.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        // write your code here
        flattenSubTree(root);
        return;
    }

    private TreeNode flattenSubTree(TreeNode n) {
        if (n == null || (n.left == null && n.right == null)) {
            return n;
        }

        TreeNode rightNode = n.right;
        n.right = flattenSubTree(n.left);
        n.left = null;
        TreeNode tmp = n;
        while (tmp.right != null) {
            tmp = tmp.right;
        }

        tmp.right = flattenSubTree(rightNode);
        return n;
    }

//    public void flatten(TreeNode root) {
//        // write your code here
//        if (root == null)
//            return;
//        Stack<TreeNode> stk = new Stack<>();
//        stk.push(root);
//        TreeNode prev = new TreeNode(-1);
//        while (!stk.isEmpty()) {
//            TreeNode current = stk.pop();
//            if (current.right != null) {
//                stk.push(current.right);
//            }
//            if (current.left != null) {
//                stk.push(current.left);
//            }
//            prev.left = null;
//            prev.right = current;
//            prev = current;
//
//        }
//
//        root = prev.right;
//    }
}
