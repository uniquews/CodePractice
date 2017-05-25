import utils.TreeNode;

/**
 * Created by shuaiwang on 5/20/17.
 */
public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        boolean leftNode = isSubtree(s.left, t);
        boolean rightNode = isSubtree(s.right, t);
        return (s.val == t.val && isSameTree(s, t)) || leftNode || rightNode;
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
