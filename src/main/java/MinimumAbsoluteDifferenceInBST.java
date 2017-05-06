import utils.TreeNode;

/**
 * Created by shuaiwang on 5/5/17.
 */
public class MinimumAbsoluteDifferenceInBST {
    private TreeNode last = null;

    private int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        if (last == null) {
            last = node;
        } else {
            result = Math.min(result, Math.abs(node.val - last.val));
            last = node;
        }
        inOrder(node.right);
    }
}
