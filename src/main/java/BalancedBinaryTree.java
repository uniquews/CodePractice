import utils.TreeNode;

/**
 * Created by shuaiwang on 7/26/16.
 */
public class BalancedBinaryTree {

    // mine
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return helper(root) == -1 ? false : true;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = helper(node);
        int right = helper(node);

        if (Math.abs(left - right) > 1 || left == -1 || right == -1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
