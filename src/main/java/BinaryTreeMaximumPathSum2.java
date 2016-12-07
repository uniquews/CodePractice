import utils.TreeNode;

/**
 * Created by shuaiwang on 7/27/16.
 */
public class BinaryTreeMaximumPathSum2 {
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftSingle = maxPathSum2(root.left);
        int rightSingle = maxPathSum2(root.right);

        return root.val + Math.max(0, Math.max(leftSingle, rightSingle));
    }
}
