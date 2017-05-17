import utils.TreeNode;

/**
 * Created by shuaiwang on 5/14/17.
 */
public class InorderSuccessorInBST {
    TreeNode prev = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return helper(root, p);
    }

    private TreeNode helper(TreeNode n, TreeNode p) {
        if (n == null)
            return null;

        if (n.val > p.val) {
            prev = n;
            TreeNode tmp = helper(n.left, p);
            if (tmp == null) {
                return prev;
            }
            return tmp;
        }

        return helper(n.right, p);
    }
}
