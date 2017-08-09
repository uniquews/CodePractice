import utils.BinaryTreeUtils;
import utils.TreeNode;

/**
 * Created by shuaiwang on 2/4/17.
 */
public class BinaryTreeLongestConsecutiveSequence {
//    class ResultType {
//        public int ascendingLen;
//        public int maxAsLen;
//
//        public ResultType(int a, int ma) {
//            ascendingLen = a;
//            maxAsLen = ma;
//        }
//    }
//    public int longestConsecutive(TreeNode root) {
//        // Write your code here
//        return divideAndConquor(root).maxAsLen;
//    }
//
//    private ResultType divideAndConquor(TreeNode n) {
//        if (n == null) {
//            return new ResultType(0, 0);
//        }
//
//        if (n.left == null && n.right == null) {
//            return new ResultType(1, 1);
//        }
//
//        ResultType leftNode = divideAndConquor(n.left);
//        ResultType rightNode = divideAndConquor(n.right);
//
//        ResultType current  = new ResultType(1,0);
//        if (n.left != null && n.val == n.left.val - 1) {
//            current.ascendingLen = leftNode.ascendingLen + 1;
//        }
//
//
//        if (n.right != null && n.val == n.right.val - 1) {
//            current.ascendingLen = rightNode.ascendingLen + 1;
//        }
//
//        current.maxAsLen = Math.max(Math.max(current.ascendingLen, leftNode.maxAsLen), rightNode.maxAsLen);
//        return current;
//    }
    private int result = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int len = 1;
        int leftLen = helper(root.left);
        int rightLen = helper(root.right);

        if (root.left != null && root.val == root.left.val - 1) {
            len = Math.max(len, 1 + leftLen);
        }

        if (root.right != null && root.val == root.right.val - 1) {
            len = Math.max(len, 1 + rightLen);
        }
        result = Math.max(result, len);
        return len;
    }

    public static void main(String[] args) {
        BinaryTreeLongestConsecutiveSequence test = new BinaryTreeLongestConsecutiveSequence();
//        test.longestConsecutive(BinaryTreeUtils.deserialize("2,#,3,2,#,1"));
        test.longestConsecutive(BinaryTreeUtils.deserialize("3,2,4,3"));
    }
}
