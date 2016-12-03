import utils.TreeNode;

/**
 * Created by shuaiwang on 7/28/16.
 */


public class ValidateBinarySearchTree {

    int lastVal = Integer.MIN_VALUE;
    boolean isFirstNode = true; // In case there is only one node, which value is Integer.Min;

    //Traverse
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean leftResult = isValidBST(root.left);
        if (!leftResult) {
            return false;
        }

        if (!isFirstNode && root.val <= lastVal) {
            return false;
        }

        isFirstNode = false;

        lastVal = root.val;

        boolean rightResult = isValidBST(root.right);
        if (!rightResult) {
            return false;
        }

        return true;
    }


    // Divide & Conquer
//    private class ResultType
//    {
//        boolean isBst;
//        int minVal;
//        int maxVal;
//
//        ResultType(boolean isBst, int maxVal, int minVal)
//        {
//            this.isBst = isBst;
//            this.maxVal = maxVal;
//            this.minVal = minVal;
//        }
//    }
//
//    public boolean isValidBST(TreeNode root) {
//        ResultType result = helper(root);
//        return result.isBst;
//
//    }
//
//    private ResultType helper(TreeNode n)
//    {
//        if (n == null)
//        {
//            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        }
//
//        ResultType leftResult = helper(n.left);
//        ResultType rightResult = helper(n.right);
//
//        if (leftResult.isBst == false || rightResult.isBst == false)
//        {
//            return new ResultType(false, 0, 0);
//        }
//
//        if ((n.left != null && leftResult.maxVal >= n.val) ||
//                n.right != null && rightResult.minVal<= n.val)
//        {
//            return new ResultType(false, 0, 0);
//        }
//
//        //Math.max(n.val, rightResult.maxVal) is in case that the rightResult is Integer.MIN
//        return new ResultType(true, Math.max(n.val, rightResult.maxVal), Math.min(n.val, leftResult.minVal));
//    }
}
