import utils.TreeNode;

/**
 * Created by shuaiwang on 7/28/16.
 */


public class ValidateBinarySearchTree {

    class ReturnType {
        public boolean isValid;
        public int minVal;
        public int maxVal;
        public ReturnType() {}
        public ReturnType(boolean v, int m, int n) {
            isValid = v;
            minVal = m;
            maxVal = n;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return helper(root).isValid;
    }

    private ReturnType helper(TreeNode n) {
        if (n == null) {
            return null;
        }

        if (n.left == null && n.right == null) {
            return new ReturnType(true, n.val, n.val);
        }

        ReturnType leftNode = helper(n.left);
        ReturnType rightNode = helper(n.right);

        ReturnType result = new ReturnType();
        result.minVal = n.val;
        result.maxVal = n.val;
        result.isValid = true;

        if (leftNode != null) {
            result.minVal = leftNode.minVal;
            if (n.val <= leftNode.maxVal || !leftNode.isValid) {
                result.isValid = false;
            }
        }

        if (rightNode != null) {
            result.maxVal = rightNode.maxVal;
            if (n.val >= rightNode.minVal || !rightNode.isValid) {
                result.isValid = false;
            }
        }
        return result;
    }
}
