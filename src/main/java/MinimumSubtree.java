import utils.BinaryTreeUtils;
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
            return new ResultType(0, Integer.MAX_VALUE, null);
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

    public static void main(String[] args) {
        MinimumSubtree test = new MinimumSubtree();
//        TreeNode a = new TreeNode(1);
//        TreeNode b = new TreeNode(2);
//        TreeNode c = new TreeNode(3);
//        TreeNode d = new TreeNode(4);
//        TreeNode e = new TreeNode(5);
//        TreeNode f = new TreeNode(6);
//        TreeNode g = new TreeNode(7);
//
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
//        c.left = f;
//        c.right = g;

//        String input = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16";
//        BinaryTreeUtils u = new BinaryTreeUtils();
//        TreeNode result = test.findSubtree(BinaryTreeUtils.deserialize(input));
//        System.out.print(result.val);

        Integer a = 1;
        System.out.print(a.compareTo(null));
    }
}
