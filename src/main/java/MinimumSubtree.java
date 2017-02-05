import utils.TreeNode;

/**
 * Created by shuaiwang on 2/4/17.
 */
public class MinimumSubtree {
    class ResultType {
        public int sum;
        public int minSum;
        public TreeNode minSumTreeNode;
        public ResultType(int s, int m, TreeNode node) {
            sum = s;
            minSum = m;
            minSumTreeNode = node;
        }
    };

    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        return divideAndConquor(root).minSumTreeNode;
    }

    private ResultType divideAndConquor(TreeNode n) {
        if (n == null) {
            return new ResultType(Integer.MAX_VALUE, Integer.MAX_VALUE, null);
        }

        if (n.left == null && n.right == null) {
            return new ResultType(n.val, n.val, n);
        }

        ResultType leftNode = divideAndConquor(n.left);
        ResultType rightNode = divideAndConquor(n.right);

        int sum = leftNode.sum + rightNode.sum + n.val;
        if (sum < leftNode.minSum && sum < rightNode.minSum) {
            return new ResultType(sum, sum, n);
        }

        if (leftNode.minSum < rightNode.minSum) {
            return new ResultType(sum, leftNode.minSum, leftNode.minSumTreeNode);
        } else {
            return new ResultType(sum, rightNode.minSum, rightNode.minSumTreeNode);
        }
    }
}
