package b;

import utils.TreeNode;

/**
 * Created by bohan on 5/14/17.
 */
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode candidate = null;
        while (root != null) {
            if (p.val < root.val) {
                candidate = root;
                root = root.left;
            } else if (p.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        if (root == null) {
            return null;
        }
        TreeNode next = findMin(root.right);
        return next == null ? candidate : next;
    }

    private TreeNode findMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
