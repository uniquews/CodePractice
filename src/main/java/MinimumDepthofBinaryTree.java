import utils.TreeNode;

/**
 * Created by shuaiwang on 8/1/16.
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }

        int leftTree = minDepth(root.left);
        int rightTree = minDepth(root.right);

        if (leftTree == 0 && rightTree == 0) {
            return 1;
        }

        if (leftTree == 0 || rightTree == 0) {
            return Math.max(leftTree, rightTree) + 1;
        }

        return Math.min(leftTree, rightTree) + 1;
    }
}
