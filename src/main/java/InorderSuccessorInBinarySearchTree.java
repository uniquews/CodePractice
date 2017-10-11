import utils.TreeNode;

/**
 * Created by shuaiwang on 7/28/16.
 */
public class InorderSuccessorInBinarySearchTree {
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode suc = null;
//        while (root != null) {
//            if (root.val <= p.val) {
//                root = root.right;
//            } else {
//                suc = root;
//                root = root.left;
//            }
//        }
//        return suc;
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

