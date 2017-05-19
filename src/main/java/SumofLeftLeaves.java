import utils.TreeNode;

/**
 * Created by shuaiwang on 5/18/17.
 */
public class SumofLeftLeaves {
    public int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root.left, true);
        traverse(root.right, false);
        return sum;
    }

    private void traverse(TreeNode n, boolean isLeft) {
        if (n == null)
            return;

        if (n.left == null && n.right == null && isLeft) {
            sum += n.val;
            return;
        }

        traverse(n.left, true);
        traverse(n.right, false);
    }
}
