import utils.TreeNode;

/**
 * Created by shuaiwang on 7/28/16.
 */
public class InorderSuccessorInBinarySearchTree {
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        // write your code here
//        if (root == null) {
//            return null;
//        }
//
//        TreeNode result = null;
//        while (root != null && root.val != p.val) {
//            if (root.val > p.val) {
//                result = root;
//                root = root.left;
//            } else {
//                root = root.right; // small and not equal
//            }
//        }
//
//        if (root.right == null) {
//            return result;
//        }
//
//        root = root.right;
//        while (root.left != null) {
//            root = root.left;
//        }
//
//        return root;
//
//    }

    private TreeNode last = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        helper(root, p);
        return last;
    }

    private void helper(TreeNode n, TreeNode p) {
        if (n == null) {
            return;
        }

        if (n.val <= p.val) {
            helper(n.right, p);
        } else {
            last = n;
            helper(n.left, p);
        }
    }
}
