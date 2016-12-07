import utils.TreeNode;

/**
 * Created by shuaiwang on 7/27/16.
 */
public class BinaryTreeMaximumPathSum {
    private class ResultType {
        int singlePath;
        int maxPath;

        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    public int maxPathSum(TreeNode root) {
        // write your code here
        return helper(root).maxPath;
    }

    private ResultType helper(TreeNode n) {
        if (n == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        ResultType leftResult = helper(n.left);
        ResultType rightResult = helper(n.right);

        int singlePath = n.val + Math.max(0, Math.max(leftResult.singlePath, rightResult.singlePath));

        int maxFromChildren = Math.max(leftResult.maxPath, rightResult.maxPath);
        int maxPath = Math.max(maxFromChildren, (Math.max(leftResult.singlePath, 0) + Math.max(rightResult.singlePath, 0) + n.val));
        return new ResultType(singlePath, maxPath);
    }

}
