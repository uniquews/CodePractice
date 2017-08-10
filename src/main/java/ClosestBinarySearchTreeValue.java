import utils.TreeNode;

/**
 * Created by shuaiwang on 3/30/17.
 */
public class ClosestBinarySearchTreeValue {
//    public int closestValue(TreeNode root, double target) {
//        if (root == null) {
//            return Integer.MAX_VALUE;
//        }
//
//        TreeNode next;
//        if (root.val > target) {
//            if (root.left == null) {
//                return root.val;
//            }
//            next = root.left;
//        } else {
//            if (root.right == null) {
//                return root.val;
//            }
//            next = root.right;
//        }
//        int closetNode = closestValue(next, target);
//        return Math.abs(root.val - target) > Math.abs(closetNode - target) ? root.val : closetNode;
//    }

    public int closestValue(TreeNode root, double target) {
        if (root.val >= target) {
            if (root.left == null) {
                return root.val;
            } else {
                int fromLeft = closestValue(root.left, target);
                return Math.abs(root.val - target) > Math.abs(fromLeft - target) ? fromLeft : root.val;
            }
        } else {
            if (root.right == null) {
                return root.val;
            } else {
                int fromRight = closestValue(root.right, target);
                return Math.abs(root.val - target) >  Math.abs(fromRight - target) ? fromRight : root.val;
            }
        }
    }
}
