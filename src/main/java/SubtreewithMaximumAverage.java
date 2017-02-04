import utils.TreeNode;

/**
 * Created by shuaiwang on 2/4/17.
 */
public class SubtreewithMaximumAverage {
    class ResultType {
        public int sum;
        public int node;
        public TreeNode maxAvgTreeNode;
        public double maxAvg;

        public ResultType(int s, int n, TreeNode nodeWithMaxAvg, double avg) {
              sum = s;
              node = n;
              maxAvgTreeNode = nodeWithMaxAvg;
              maxAvg = avg;
        }
    };

    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        return divideAndConquer(root).maxAvgTreeNode;
    }

    private ResultType divideAndConquer(TreeNode n) {
        if (n == null) {
            return new ResultType(0,0, null, 0);
        }

        if (n.left == null && n.right == null) {
            return new ResultType(n.val, 1, n, n.val);
        }

        ResultType leftNode = divideAndConquer(n.left);
        ResultType rightNode = divideAndConquer(n.right);

        int currentSum = leftNode.sum + rightNode.sum + n.val;
        int currentNode = leftNode.node + rightNode.node + 1;
        double currentAvg = (1.0) * currentSum / currentNode;

        if (currentAvg > leftNode.maxAvg && currentAvg > rightNode.maxAvg) {
            return new ResultType(currentSum, currentNode, n, currentAvg);
        }

        if (leftNode.maxAvg < rightNode.maxAvg) {
            return new ResultType(currentSum, currentNode, rightNode.maxAvgTreeNode, rightNode.maxAvg);
        } else {
            return new ResultType(currentSum, currentNode, leftNode.maxAvgTreeNode, leftNode.maxAvg);
        }
    }

    public static void main(String[] args) {
        SubtreewithMaximumAverage test = new SubtreewithMaximumAverage();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(-5);
        TreeNode c = new TreeNode(11);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(-2);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        test.findSubtree2(a);
    }
}
